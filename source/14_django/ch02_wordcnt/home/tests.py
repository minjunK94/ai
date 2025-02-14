from django.test import TestCase

# Create your tests here.

words = ['홍', '홍', '화이팅', '단거']
words_dic = dict()
print(words_dic)
for word in words:
    if word in words_dic.keys():
        words_dic[word] += 1
    else:
        words_dic[word] = 1
# print(words_dic.items())
for word, cnt in words_dic.items():
    print(word, ":", cnt)