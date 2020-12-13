# 2020-2-CECD1-ChungmuSalmon-4

## How to get started?

1. First, make sure your Raspbian OS is Buster(ver.10), not Stretch(ver.9).

2. Install openCV 4.2.0 with Cmake (or download pre-built .whl file [here](https://github.com/dltpdn/opencv-for-rpi/releases))

3. Install Tensorflow 2.3.0 by following the instructions described [here](https://github.com/PINTO0309/Tensorflow-bin/#usage:)

4. Now, you're all set!

5. Download Pre-trained models
  - [Tensorflow Lite](https://drive.google.com/file/d/1_hDxZM43nBrBMH3SSE10SEt0lJmQhAAd/view?usp=sharing)
  - Tensorflow Lite - Float16 Quantized (Not Working)
  - [Tensorflow Lite - Int8](https://drive.google.com/file/d/1DeNK-CZMoqvfDhyayFjKbsId7xZH4GcE/view?usp=sharing)
  - [Tensorflow Lite - Tiny](https://drive.google.com/file/d/1Hm17rmmcDgLasHM8xhtv8rFCVL53L5Zu/view?usp=sharing)

6. Locate the .tflite file you just downloaded in ./raspbian-tflite/checkpoints

7. Move back to ./raspbian-tflite, and run
  ```bash
  $ python3 detect.py
  ```
