# 2020-2-CECD1-ChungmuSalmon-4

## How to get started?

1. First, make sure your Raspbian OS is Buster(ver.10), not Stretch(ver.9).

2. Install openCV 4.2.0 with Cmake (or download pre-built .whl file [here](https://github.com/dltpdn/opencv-for-rpi/releases))

3. Install Tensorflow 2.3.0 by following the instructions described [here](https://github.com/PINTO0309/Tensorflow-bin/#usage:)

4. Now, you're all set!

5. Download Pre-trained models
  - [Tensorflow Lite](https://drive.google.com/file/d/1tgA0FMYOVpMepJ2jO-3NPaBVsYHj6cDD/view?usp=sharing)
  - [Tensorflow Lite - Float16 Quantized](https://drive.google.com/file/d/1tdkDEmYbzkZXn9Da39Qzj_sum3vNnju5/view?usp=sharing)
  - [Tensorflow Lite - Int8](https://drive.google.com/file/d/1tFeDfaE3RZLStduTwA3eE4_n4o2-0Kp4/view?usp=sharing)
  - [Tensorflow Lite - Tiny](https://drive.google.com/file/d/1Gm7Ym1UhVHeGTSb5Pq1CMoDVojkWrwsS/view?usp=sharing)

6. Locate the .tflite file you just downloaded in ./raspbian-tflite/checkpoints

7. Move back to ./raspbian-tflite, and run
  ```bash
  $ python3 detect.py
  ```
