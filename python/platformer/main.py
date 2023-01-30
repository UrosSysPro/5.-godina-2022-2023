import sys, pygame
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
g=0.01


while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT: sys.exit()
    pygame.draw.rect(screen,(0,0,0),(0,0,width,height))

    for p in platforms:
        p.draw(screen)

    player.input(pygame.key.get_pressed())
    player.update(g,size,platforms)
    player.draw(screen)
   
    pygame.display.flip()
