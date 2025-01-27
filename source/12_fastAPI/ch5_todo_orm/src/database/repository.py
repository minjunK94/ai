from typing import List
from sqlalchemy.orm import Session
from sqlalchemy import select, update, delete
from models import ToDoRequest
from database.orm import ToDo
from database.connection import SessionFactory

def get_todos(session:Session) -> List[dict]:
    return session.scalars(select(ToDo).order_by(ToDo.id)).all()

def get_todo(todo_id:int) -> dict:
    pass

def create_todo(todo:ToDoRequest) -> str:
    pass

def update_todo(id:int, contents:str, is_done:bool) -> str:
    pass

def delete_todo(todo_id:int) -> str:
    pass

if __name__ == '__main__':
    pass
    print('1. 목록 : ', get_todos(session))
    session.close()
    # print('2. 상세보기 : ', get_todo(1))
    # print('2. 상세보기 : ', get_todo(9))
    # todo = ToDoRequest()
    # todo.contents = '추가할 todo'
    # todo.is_done = True
    # print('3. create : ', create_todo(todo))
    # print('4. update : ', update_todo(1, '내용 변경', True))
    # print('5. delete : ', delete_todo(1))