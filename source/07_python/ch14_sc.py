import schedule
import time

def job():
    print('작업 실행 되었습니다')
schedule.every(10).seconds.do(job)

while True:
    schedule.run_pending()
    time.sleep(1)