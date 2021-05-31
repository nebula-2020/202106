import os
text = ''
root = ''
for root, ds, fs in os.walk('.'):
    for f in fs:
        if f.endswith('.java') or f.endswith('.html') or f.endswith('web.xml'):
            try:
                path = '\\'.join([root, f])
                with open(path, 'r', encoding='UTF-8') as file:
                    text += f+'\n'
                    text += file.read()
            except:
                pass

path = 'C:\\Users\\Administrator\\Desktop\\read.txt'
with open(path, 'w', encoding='UTF-8') as file:
    file.write(text)
