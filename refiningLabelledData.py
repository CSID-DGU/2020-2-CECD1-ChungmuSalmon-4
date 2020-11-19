import os

##please input directory path..
filePath = '/Users/gounchoi/Desktop/test'
##please input index you want to remain..
index = '0'

def deleteLine(fileName):
    count = 0
    with open(filePath + '/' + fileName, "r") as f:
        lines = f.readlines()
    with open(filePath + '/' + fileName, "w") as f:
        for line in lines:
            if line.strip("\n")[:len(index)] == index:
                f.write(line)
                count = count + 1
    return count


def deleteFile():
    if os.path.exists(filePath):
        for file in os.scandir(filePath):
            if file.name.endswith(".txt"):
                if deleteLine(file.name) == 0:
                    os.remove(filePath + '/' + file.name)
                    os.remove(filePath + '/' + file.name[:-4] + '.jpg')


if __name__ == '__main__':
    deleteFile()