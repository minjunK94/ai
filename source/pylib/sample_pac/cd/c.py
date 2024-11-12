# smaple_pac/cd/c.py - ab/a.py를 참조
from ..ab import a

def nice():
    print('smaple_pac/cd안의 C모듈안의 nice')
    a.hello()