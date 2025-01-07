import joblib

loaded_model = joblib.load('../model/ex1_apt_price_regression.pkl')

def predict_apt_price(year, square, floor):
    input_data = [[1, int(year), int(square), int(floor)]]
    pred = loaded_model.predict(input_data)[0]
    return format(round(pred*10000), ',') + '원입니다'

if __name__=='__main__':
    year = input('년도')
    square = input('전용면적')
    floor = input('몇 층?')
    print('예측한 금액은 : ', predict_apt_price(year, square, floor))
