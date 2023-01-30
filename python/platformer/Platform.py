import pygame


class Platform:
    def __init__(self,x,y,w,h) -> None:
        self.x=x
        self.y=y
        self.width=w
        self.height=h
        self.color=(30,200,70)

    def draw(self,screen):
        pygame.draw.rect(screen,self.color,(self.x,self.y,self.width,self.height))

    def preklapaSe(self,x,y,width,height):
        if x>self.x+self.width: return False
        if y>self.y+self.height: return False
        if x+width<self.x: return False
        if y+height<self.y: return False
        return True
