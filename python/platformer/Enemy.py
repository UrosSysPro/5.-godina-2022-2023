import pygame

enemySize=50
enemyImg=pygame.image.load("sprites/slimeGreen.png")
enemyImg=pygame.transform.scale(enemyImg,(enemySize,enemySize))

class Enemy:
    def __init__(self,startX,startY,endX,endY) -> None:
        self.startX=startX
        self.startY=startY
        self.endX=endX
        self.endY=endY
        self.pos=0

    def update(self,delta):
        self.pos+=delta/1000000
        
    
    def draw(self,screen):
        x=self.startX*(1-self.pos)+self.endX*self.pos
        y=self.startY*(1-self.pos)+self.endY*self.pos
        
        screen.blit(enemyImg,(x,y))