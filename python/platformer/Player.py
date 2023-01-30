import pygame

class Player:
    x=0
    y=0
    vx=0
    vy=1
    size=30
    speed=2
    canJump=True
    jumpPower=2
    def input(self,keys):
        self.vx=0
        if keys[pygame.K_a]:
            self.vx=-self.speed
        if keys[pygame.K_d]:
            self.vx= self.speed
        if keys[pygame.K_w] and self.canJump:
            self.vy=-self.jumpPower
            self.canJump=False
    
    def update(self,g,screenSize,platforms):
        width,height=screenSize
        self.vy+=g

        self.x+=self.vx

        for p in platforms:
            if p.preklapaSe(self.x,self.y,self.size,self.size):
                self.x-=self.vx
                self.vx=0
                break

        self.y+=self.vy
        for p in platforms:
            if p.preklapaSe(self.x,self.y,self.size,self.size):
                self.y-=self.vy
                if(self.y<p.y):self.canJump=True
                self.vy=0
                
                break
        
        if self.x<0:self.x=0
        if self.y<0:self.y=0
        if self.x+self.size>width:self.x=width-self.size
        if self.y+self.size>height:
            self.canJump=True
            self.y=height-self.size

    def draw(self,screen):
        color=(255,255,255)
        pygame.draw.rect(screen,color,(self.x,self.y,self.size,self.size))