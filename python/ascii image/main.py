from PIL import Image

slika=Image.open("slika.jpg")

pixels=slika.load()

width,height=slika.size
scale=float(input("scale za sliku"))
charWidth=int(width/scale)
charHeight=int(height/scale)

paleta=['.',',','_','-','+','1','7','8','#']

for j in range(charHeight):
    for i in range(charWidth):
        x=int(i*width/charWidth)
        y=int(j*height/charHeight)
        r,g,b=pixels[x,y]
        p=(r+g+b)/3
        p=p*len(paleta)/256
        p=int(p)
        print(paleta[p]+paleta[p],end="")
    print()
        

