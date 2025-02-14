from django.http import HttpResponse
from django.shortcuts import render

def wordinput(request):
    return render(request, 'wordcnt/wordinput.html')

def about(request):
    return  render(request,
                   "wordcnt/about.html")

def result(request):
    # print(request.POST)
    fulltxt = request.POST['fulltxt']
    strlength = len(fulltxt)
    words = fulltxt.split()
    wordcnt = len(words)
    words_dic = dict()
    for word in words:
        if word in words_dic.keys():
            words_dic[word] += 1
        else:
            words_dic[word] = 1
    context = {
        'full' : fulltxt,
        'strlength' : strlength,
        'wordcnt' : wordcnt,
        'dict' : words_dic.items()
    }
    return render(request,
                  'wordcnt/result.html',
                  context)