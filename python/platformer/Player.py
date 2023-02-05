import pygame

class Player:
    x=0
    y=0
    vx=0
    vy=1
    size=30
    speed=4
    canJump=True
    jumpPower=7

    def __init__(self) -> None:
        self.still=pygame.image.load("sprites/alienGreen_front.png")
        width=self.still.get_rect().width
        height=self.still.get_rect().height
        self.still=pygame.transform.scale(self.still,(self.size,self.size*2))
        self.walk=[
            pygame.image.load("sprites/alienGreen_walk1.png"),
            pygame.image.load("sprites/alienGreen_walk2.png")
        ]

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

        self.canJump=False
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
        # pygame.draw.rect(screen,color,(self.x,self.y,self.size,self.size))
        screen.blit(self.still,(self.x,self.y-self.size))