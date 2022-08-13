'''1차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=1
# endRow=1000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output1.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''2차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=1001
# endRow=2000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output2.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''3차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=2001
# endRow=3000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output3.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''4차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=3001
# endRow=4000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output4.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''5차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=4001
# endRow=5000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output5.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''6차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=5001
# endRow=6000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output6.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''7차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=6001
# endRow=7000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output7.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''8차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=7001
# endRow=8000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output8.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''9차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=8001
# endRow=9000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output9.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''10차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=9001
# endRow=10000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output10.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''11차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=10001
# endRow=11000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output11.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''12차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=11001
# endRow=12000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output12.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")


'''13차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=12001
# endRow=13000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output13.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''14차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=13001
# endRow=14000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output14.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''15차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=14001
# endRow=15000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output15.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''16차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=15001
# endRow=16000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output16.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''17차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=16001
# endRow=17000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output17.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''18차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=17001
# endRow=18000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output18.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''19차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=18001
# endRow=19000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output19.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''20차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=19001
# endRow=20000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output20.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''21차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=20001
# endRow=21000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output21.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''22차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=21001
# endRow=22000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output22.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''23차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=22001
# endRow=23000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output23.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''24차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=23001
# endRow=24000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output24.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''25차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=24001
# endRow=25000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output25.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")


'''26차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=25001
# endRow=26000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output26.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''27차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=26001
# endRow=27000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output27.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''28차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=27001
# endRow=28000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output28.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''29차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=28001
# endRow=29000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output29.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''30차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=29001
# endRow=30000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output30.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''31차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=30001
# endRow=31000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output31.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''32차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=31001
# endRow=32000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output32.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''33차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=32001
# endRow=33000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output33.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''34차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=33001
# endRow=34000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output34.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''35차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=34001
# endRow=35000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output35.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''36차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=35001
# endRow=36000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output36.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''37차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=36001
# endRow=37000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output37.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''38차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=37001
# endRow=38000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output38.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''39차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=38001
# endRow=39000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output39.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''40차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=39001
# endRow=40000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output40.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''41차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=40001
# endRow=41000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output41.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")


'''42차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=41001
# endRow=42000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output42.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''43차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=42001
# endRow=43000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output43.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''44차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=43001
# endRow=44000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output44.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''45차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=44001
# endRow=45000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output45.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''46차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=45001
# endRow=46000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output46.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''47차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=46001
# endRow=47000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output47.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''48차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=47001
# endRow=48000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output48.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''49차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=48001
# endRow=49000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output49.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''50차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=49001
# endRow=50000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output50.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''51차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=50001
# endRow=51000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output51.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''52차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=51001
# endRow=52000
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output52.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")

'''53차'''
# import json, urllib.request
# import csv
#
# apikey='cd254fc2716f4a8c9034'
#
# startRow=52001
# endRow=52661
#
# url='http://openapi.foodsafetykorea.go.kr/api/'+apikey+'/I2570/json/'+str(startRow)+'/'+str(endRow)
#
# data=urllib.request.urlopen(url).read()
# output=json.loads(data)
# output=output['I2570']
# output=output['row']
# print(output)
# #print(type(output))
#
# print(output[0].keys())
# output_file='api.Output53.csv'
#
# output_columns=['BRCD_NO', 'PRDT_NM']
#
# try:
#     with open(output_file,'w',newline='',encoding='utf-8-sig') as csvfile:
#         writer=csv.DictWriter(csvfile,output[0].keys())
#         writer.writeheader()
#         for data in output:
#             writer.writerow(data)
# except:
#     print("Error")