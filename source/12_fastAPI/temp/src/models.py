# FasAPI 에서 post 방식 요청파라미터를 보낼 때 타입 검증
from pydantic import BaseModel

class ToDoRequest(BaseModel):
    contents : str | None=''
    is_done : bool| None=False
