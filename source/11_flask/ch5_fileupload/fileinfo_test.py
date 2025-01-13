# 특정폴더(upload/) 안의 파일들의 정보
import os
import datetime
from time import ctime


def stamp2real(stamp):
    # stamp(1970.1.1 ~ 특정 시점까지 초수) 를 입력받아 특정 시점을 가독성높은 문자
    return datetime.datetime.fromtimestamp(stamp)

def info(filename):
    '파일 생성시간, 마지막수정시간, 마지막액세스시간, 파일사이즈를 return'
    ctime = os.path.getctime(filename)
    mtime = os.path.getmtime(filename)
    atime = os.path.getatime(filename)
    size = os.path.getsize(filename)
    return ctime, mtime, atime, size
# print(stamp2real(1736736126.8933022))
filelist = os.listdir('./upload')
# print(filelist)
for filename in filelist:
    # print('파일명 :', filename)
    ctime, mtime, atime, size = info('./upload/'+filename)
    print('파일명 :', filename)
    print('파일 생성 시간 :', stamp2real(ctime))
    print('파일 수정 시간 :', stamp2real(mtime))
    print('파일 접근 시간 :', stamp2real(atime))
    if size<=1000000 : # size(byte단위)
        print("{:.2f}KB".format(size/1024))
    else:
        print("{:.2f}MB".format(size/(1024*1024)))