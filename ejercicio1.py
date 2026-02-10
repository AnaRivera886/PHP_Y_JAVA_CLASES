## REALIZAR UN ALGORITMO QUE CALCULE EL FACTORIAL DE UN NUMERO

numero= int(input("Digite el numero que quiera hacer la factorizacion: "))
org= numero
fact= 1

while numero > 0:
    fact *= numero
    numero -=1
print(f"El factorial del {org} es: {fact}")


