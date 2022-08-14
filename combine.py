import pandas as pd
import glob
import os
input_path = r'C:/Users/82103/Desktop/SSWU_SW'
output_file = r'C:/Users/82103/Desktop/SSWU_SW/foodData.csv'

file_list = glob.glob(os.path.join(input_path, '*.csv'))

with open(output_file, 'w') as write_file:
	for i, file_name in enumerate (file_list):
		with open(file_name, 'r', encoding='UTF-8') as original_file:
			n = 0
			while True:
				line = original_file.readline()
				if n == 0: # 모든 csv 파일 릴레이션 삭제
					n += 1
					continue
				if not line:
					print(f'File[{i}] Succeed..!')
					break
				write_file.write(line)
			n += 1

print('File Mergin Succeed..!')