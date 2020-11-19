import cv2
import random
import colorsys
import numpy as np
import requests
import datetime

from core.config import cfg


def read_class_names(class_file_name):
    names = {}
    with open(class_file_name, 'r') as data:
        for ID, name in enumerate(data):
            names[ID] = name.strip('\n')
    return names


def calc_object_number(bboxes):
    class_names = read_class_names(cfg.YOLO.CLASSES)
    counts = dict()

    out_boxes, out_scores, out_classes, num_boxes = bboxes
    for i in range(num_boxes[0]):
        """ Count the number of objects """

        class_index = int(out_classes[0][i])
        class_name = class_names[class_index]
        counts[class_name] = counts.get(class_name, 0) + 1

    return counts


def sent_to_server(counts):
    api_url = "http://localhost:3000/counts"
    now = datetime.datetime.now()

    person_count = counts.get('person') if counts.get('person') is not None else 0
    tent_count = counts.get('tent') if counts.get('tent') is not None else 0

    new_counting_result = {
        "time": now.strftime('%Y-%m-%d %H:%M:%S'),
        "location": "CampingZone",
        "person": str(person_count),
        "tents": str(tent_count)
    }

    print(new_counting_result)

    response = requests.post(
        url=api_url,
        data=new_counting_result
    )

    print(response)
    print(response.text)

    return True


def draw_bbox(image, bboxes, classes=read_class_names(cfg.YOLO.CLASSES), show_label=True):
    num_classes = len(classes)
    image_h, image_w, _ = image.shape
    hsv_tuples = [(1.0 * x / num_classes, 1., 1.) for x in range(num_classes)]
    colors = list(map(lambda x: colorsys.hsv_to_rgb(*x), hsv_tuples))
    colors = list(map(lambda x: (int(x[0] * 255), int(x[1] * 255), int(x[2] * 255)), colors))

    random.seed(0)
    random.shuffle(colors)
    random.seed(None)

    out_boxes, out_scores, out_classes, num_boxes = bboxes
    for i in range(num_boxes[0]):
        if int(out_classes[0][i]) < 0 or int(out_classes[0][i]) > num_classes: continue
        coor = out_boxes[0][i]
        coor[0] = int(coor[0] * image_h)
        coor[2] = int(coor[2] * image_h)
        coor[1] = int(coor[1] * image_w)
        coor[3] = int(coor[3] * image_w)

        fontScale = 0.5
        score = out_scores[0][i]
        class_ind = int(out_classes[0][i])
        bbox_color = colors[class_ind]
        bbox_thick = int(0.6 * (image_h + image_w) / 600)
        c1, c2 = (coor[1], coor[0]), (coor[3], coor[2])
        cv2.rectangle(image, c1, c2, bbox_color, bbox_thick)

        if show_label:
            bbox_mess = '%s: %.2f' % (classes[class_ind], score)
            t_size = cv2.getTextSize(bbox_mess, 0, fontScale, thickness=bbox_thick // 2)[0]
            c3 = (c1[0] + t_size[0], c1[1] - t_size[1] - 3)
            cv2.rectangle(image, c1, (np.float32(c3[0]), np.float32(c3[1])), bbox_color, -1) #filled

            cv2.putText(image, bbox_mess, (c1[0], np.float32(c1[1] - 2)), cv2.FONT_HERSHEY_SIMPLEX,
                        fontScale, (0, 0, 0), bbox_thick // 2, lineType=cv2.LINE_AA)

    return image
