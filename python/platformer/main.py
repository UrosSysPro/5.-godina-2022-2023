import sys, pygame
from Enemy import Enemy
from Player import Player
from Platform import Platform
pygame.init()

size = width, height = 800,600
screen = pygame.display.set_mode(size)

player=Player()
platforms=[
    Platform(600,450,200,50),
    Platform(0,300,400,50)
]
enemies=[
    Enemy(600,400,700,400)
]
g=0.1

skyColor=(50,70,230)
lastFrame=pygame.time.get_ticks()

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT: sys.exit()
    startTime=pygame.time.get_ticks()
    delta=startTime-lastFrame
    
    pygame.draw.rect(screen,skyColor,(0,0,width,height))
    player.input(pygame.key.get_pressed())
    
    player.update(g,size,platforms)
    for e in enemies:
        e.update(delta)

    for p in platforms:
        p.draw(screen)
    for e in enemies:
        e.draw(screen)
    player.draw(screen)
   
    pygame.display.flip()

    endTime=pygame.time.get_ticks()

    delay=int(1000/60-(endTime-startTime));
    if(delay>0):
        pygame.time.wait(delay)

