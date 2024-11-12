'''
sample_pac/ab/__init__.py
ab 패키지를 import 할대 자동 실행되는 파일
from sample-pac.ab import * 수행시 a모듈만 자동으로 import 되도록 하기 위해 all 셋팅
'''
__all__ = ['a']
print('sample_pac 패키지 안의 ab패키지가 로드 되었습니다.')