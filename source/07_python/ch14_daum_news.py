from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time
import pandas as pd

# 입력한 페이지 만큼 검색하여 결과를 데이터프레임으로 출력
query = input('검색 하실 단어를 입력해주세요 : ')
page_numbers = int(input('크롤링 할 페이지수 입력해주세요 : '))
driver = webdriver.Chrome()
time.sleep(1)
url = 'https://www.daum.net/'
driver.get(url)
driver.implicitly_wait(0.5) # time.sleep(0.5) 두개가 동일한 명령어
driver.find_element(By.CLASS_NAME, 'tf_keyword').click()
driver.find_element(By.CSS_SELECTOR, 'input[type="text"]').send_keys(query)
driver.find_element(By.CLASS_NAME, 'btn_ksearch').click()
time.sleep(1)
tabs = driver.find_elements(By.CSS_SELECTOR, 'ul.list_tab > li')
for tab in tabs:
    if '뉴스' in tab.text:
        tab.click()
        break 
        
news_list = []

for page_number in range(1, page_numbers+1):
    bodies = driver.find_elements(By.CSS_SELECTOR, 'div.item-title > strong.tit-g')
    for body in bodies:
        a = body.find_element(By.TAG_NAME, 'a')
        title = a.text
        link = a.get_attribute('href')
        news_list.append([title, link])

    page_nav = driver.find_element(By.CSS_SELECTOR, 'div.inner_paging')
    next_page = page_nav.find_element(By.LINK_TEXT, str(page_number+1))
    time.sleep(1)
    next_page.click()
driver.close()
pd.DataFrame(news_list, columns=['title', 'link']).to_csv('삭제예정.csv', encoding='cp949')
