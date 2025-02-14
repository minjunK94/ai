# 실행 시 cd src 입력 후 src 경로로 들어가서 uvicorn 실행

# src -> 소스 루트
# pip install fastapi
# pip install uvicorn --no-cache-dir
# pip install jinja2
# pip install python-multipart
# pip freeze > 파일명(requirements).확장자(txt)
from fastapi import FastAPI
from fastapi import Request  # 특정 요청경로에서 template로 갈 핸들러 함수 매개 변수
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from sqlalchemy.orm import Session
from starlette.responses import RedirectResponse  # redirect
from database.connection import SessionFactory
from models import ToDoRequest
from fastapi import Form  # create(POST방식)
from fastapi import HTTPException  # 예외처리
import os
from database.repository import get_todos, get_todo, create_todo, update_todo, delete_todo
from fastapi import Depends
from database.connection import get_db

app = FastAPI()
BASE_DIR = os.path.dirname(os.path.abspath(__file__))  # 현재 폴더의 절대경로
app.mount('/static', StaticFiles(directory=os.path.join(BASE_DIR, '../static')), name='static')
templates = Jinja2Templates(directory=os.path.join(BASE_DIR, '../templates'))

@app.get('/')
@app.get('/todos')
@app.post('/todos')  # create 후 현 위치로
async def get_todos_handler(request:Request,  # html로 전송
                            order:str|None=None,
                            session:Session=Depends(get_db)):
    todos = get_todos(session)
    if order and order.upper() == 'DESC':
        todos = todos[::-1]
    return templates.TemplateResponse('todos.html',  # todo 목록, todo 입력 form
                                      {'request':request, 'todos':todos,
                                       'order':order.upper() if order else ''})


# 상세보기 : 없는 id 조회시 404 예외 발생
@app.get('/todos/{todo_id}', status_code=200)  # status_code=200 기본값
async def get_todo_detail_handler(request:Request, todo_id:int, session:Session=Depends(get_db)):
    todo = get_todo(session, todo_id)
    if todo:
        return templates.TemplateResponse('todo.html', {'request':request, 'todo':todo})
    raise HTTPException(status_code=404, detail='없는 id입니다')

@app.exception_handler(404)
def error_handler(request:Request, exe:HTTPException):
    return templates.TemplateResponse('page_not_found.html',
                                      {'request':request}, status_code=404)


@app.post('/create')
# async def create_todo_handler(id:int=Form(), contents:str, is_done:bool|None=False)
async def create_todo_handler(todo:ToDoRequest=Form(), session:Session=Depends(get_db)):
    create_todo(session, todo)
    return RedirectResponse('/todos')

# 예외 발생 추가
@app.delete('/delete/{todo_id}', status_code=200)
async def delete_todo_handler(todo_id:int, session:Session=Depends(get_db)):
    result = delete_todo(session, todo_id)
    if result:
        return result
    raise HTTPException(status_code=404, detail='예외 페이지로 가므로 이 detail 메세지는 출력되지 않음')

# 예외 발생 추가
@app.get('/update/{id}', status_code=200)
async def get_updatetodo_handler(request:Request, id:int, session:Session=Depends(get_db)):
    todo = get_todo(session, id)
    if todo:
        return templates.TemplateResponse('update.html',
                                          {'request':request, 'todo':todo})
    raise HTTPException(status_code=404, detail='예외 페이지로 가므로 이 detail 메세지는 출력되지 않음')

# 예외 발생 추가
@app.patch('/update/{id}/{contents}/{is_done}', status_code=200)
async def update_todo_handler(id:int, contents:str, is_done:bool, session:Session=Depends(get_db)):
    result = update_todo(session, id, contents, is_done)
    if result:
        return result
    raise HTTPException(status_code=404, detail='예외 페이지로 가므로 이 detail 메세지는 출력되지 않음')