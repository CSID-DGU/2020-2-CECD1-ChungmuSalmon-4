import cv2
import numpy as np
import tensorflow as tf

from core import utils
from core.yolov4 import filter_boxes

MODEL_PATH = '/Users/cathfish/Documents/GraduatePJT/technonia-512-fp16.tflite'  # 모델 파일 경로
IOU_THRESHOLD = 0.45
SCORE_THRESHOLD = 0.25
INPUT_SIZE = 512


def main(img_path):
    image = cv2.imread(img_path)
    image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

    image_data = cv2.resize(image, (INPUT_SIZE, INPUT_SIZE))
    image_data = image_data / 255.

    images_data = []
    for i in range(1):
        images_data.append(image_data)
    images_data = np.asarray(images_data).astype(np.float32)

    interpreter = tf.lite.Interpreter(model_path=MODEL_PATH)
    interpreter.allocate_tensors()
    input_details = interpreter.get_input_details()
    output_details = interpreter.get_output_details()
    # print(input_details)
    # print(output_details)
    interpreter.set_tensor(input_details[0]['index'], images_data)
    interpreter.invoke()
    pred = [interpreter.get_tensor(output_details[i]['index']) for i in range(len(output_details))]
    boxes, pred_conf = filter_boxes(pred[0], pred[1], score_threshold=0.25, input_shape=tf.constant([INPUT_SIZE, INPUT_SIZE]))

    boxes, scores, classes, valid_detections = tf.image.combined_non_max_suppression(
        boxes=tf.reshape(boxes, (tf.shape(boxes)[0], -1, 1, 4)),
        scores=tf.reshape(
            pred_conf, (tf.shape(pred_conf)[0], -1, tf.shape(pred_conf)[-1])),
        max_output_size_per_class=50,
        max_total_size=50,
        iou_threshold=IOU_THRESHOLD,
        score_threshold=SCORE_THRESHOLD
    )

    pred_bbox = [boxes.numpy(), scores.numpy(), classes.numpy(), valid_detections.numpy()]
    result = utils.draw_bbox(image, pred_bbox)
    counts = utils.calc_object_number(pred_bbox)

    # 서버 측으로 데이터 전송
    utils.sent_to_server(counts)

    result = cv2.cvtColor(np.array(result), cv2.COLOR_RGB2BGR)
    cv2.imwrite('result.png', result)


if __name__ == '__main__':
    img_path = './data/image2.JPG'
    try:
        main(img_path)
    except SystemExit:
        pass
