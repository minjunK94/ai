# pip freeze > 파일명(requirements.txt)

# 실행 시 cd src 입력 후 src 경로로 들어가서 uvicorn 실행

from fastapi import FastAPI
from fastapi import Request  # 특정 요청경로에서 template로 갈 핸들러 함수 매개 변수
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from starlette.responses import RedirectResponse  # redirect
# from pydantic import BaseModel  # 자동 타입 체크
from models import ToDoRequest
from fastapi import Form  # create(POST방식)
from fastapi import HTTPException
import os

app = FastAPI()
BASE_DIR = os.path.dirname(os.path.abspath(__file__))  # 현재 폴더의 절대경로
app.mount('/static', StaticFiles(directory=os.path.join(BASE_DIR, '../static')), name='static')
templates = Jinja2Templates(directory=os.path.join(BASE_DIR, '../templates'))

# @app.get('/')
# async def health_check_handler():
#     return {'status':'ok'}

todo_data = {
    1:{'id':1,
       'contents':'딥러닝 공부',
       'is_done':True},
    2:{'id':2,
       'contents':'FaseAPI 공부',
       'is_done':False},
    3:{'id':3,
       'contents':'머신러닝 공부',
       'is_done':False}
}

@app.get('/')
# async def health_check_handler():
#     return {'status':'ok'}
# /todos(할 일 1부터 출력), /todos?order=desc(할 일 역순으로 출력)
@app.get('/todos')
@app.post('/todos')
async def get_todos_handler(request:Request,  # html로 전송
                            order:str|None=None):
    # return todo_data
    todos = list(todo_data.values())  # 딕셔너리 -> 리스트 변환
    if order and order.upper() == 'DESC':
        todos = todos[::-1]
    next_id = max(todo_data.keys())+1
    return templates.TemplateResponse('todos.html',  # todos 목록, todos 입력 form
                                      {'request':request, 'todos':todos, 'next_id':next_id,
                                       'order':order.upper() if order else ''})
# 상세보기 : 없는 id 조회시 404 예외 발생
@app.get('/todos/{todo_id}')  # status_code=200 기본값
async def get_todo_detail_handler(request:Request, todo_id:int):
    todo = todo_data.get(todo_id, {})  # todo_data[todo_id]
    if todo:
        return templates.TemplateResponse('todo.html',
                                      {'request':request, 'todo':todo})
    raise HTTPException(status_code=404,
                        detail='없는 id입니다')
@app.exception_handler(404)
def error_handler(requset:Request, exe:HTTPException):
    return templates.TemplateResponse('page_not_found.html',
                                      {'request':requset},
                                      status_code=404)
@app.post('/create')
async def create_todo_handler(todo:ToDoRequest=Form()):
    # print('form 태그로 부터 입력된 todo',todo)
    todo_data[todo.id] = todo.dict()
    return RedirectResponse('/todos')

@app.delete('/delete/{todo_id}', status_code=200)
async def delete_todo_handler(todo_id:int):
    # del todo_data[todo_id]
    # key 가 없는 todo_id 를 입력할 경우 None 값이 입력되고
    todo = todo_data.pop(todo_id, None)
    if todo:
        return f'{todo_id}번 todo 삭제 성공'
    return f'{todo_id} 해당 번호는 등록되어있지 않는 todo여서 삭제 실패하였습니다.'

@app.get('/update/{id}')
async def get_updatetodo_handler(request:Request,
                                 id:int):
    todo = todo_data.get(id)
    return templates.TemplateResponse('update.html',
                                      {'request':request,
                                       'todo':todo})

# 수정
# HTML로 return 할 필요 없음
@app.patch('/update/{id}/{contents}/{is_done}')
async def update_todo_handler(id:int, contents:str, is_done:bool):
    # 수행될 딕셔너리
    # todo 데이터 변경하지 않기 위해 .copy()
    todo = todo_data.get(id)
    if todo:
        todo['contents'] = contents
        todo['is_done']  = is_done
        return f'{id}번 {contents} 수정 완료'
    return {}
