TALLER PRÁCTICO

Una comercializadora de electrodomésticos requiere el desarrollo de un sistema de facturación que le permita calcular el valor de sus productos entre los cuales se encuentran también televisores y neveras, el precio base de cualquier electrodoméstico se da de acuerdo a los siguientes criterios:

Consumo		Precio		
A		450 000
B		350 000
C		250 000

Procendencia	Precio
Nacional		250 000
Internacional	350 000

Adicionalmente, los televisores que cuenten con un tamaño superior a las 40 pulgadas incrementan su precio en un 30%, y si tiene sintonizador TDT aumentan 250 000, por su parte, las neveras con una capacidad mayor a 120 litros incrementan su precio un 5% por cada 10 litros adicionales.

Desarrolle en Java un programa que le permita administrar N número de electrodomésticos, y calcular su precio final totalizando por aparte electrodomésticos, televisores y neveras vendidas.

ANÁLISIS

1. ¿Qué ingresa el usuario?
Ingresa un archivo donde la primera línea es el número de electrodomésticos N.
	
Cada una de las siguientes N líneas posee la descripción del electrodoméstico de la siguiente forma:
Tipo de electrodoméstico: Televisión (tv), Nevera (nev), Otro electrodoméstico (otro)
Tipo de consumo: a:450 000, b:350 000, c:250 000
Procedencia: Nacional (nal):250 000, Internacional (intl):350 000
Si es televisor, indicar el tamaño en pulgadas y si tiene sincronizador TDT (s: sí, n: no).
Si es nevera, indicar la capacidad en litros.
Nota: Separar cada característica de la descripción del electrodoméstico por espacios en blanco.
Ejemplo:
4
nev C NAL 100
NEV A INTL 10
TV B INTL 40 S
NEV A NAL 150

NOTA IMPORTANTE: Para ejecutar poner la ruta o nombre del archivo de consumo.txt, procedencia.txt.
		A la final traté de agregar un comprimido .jar, pero no sé por qué no me funcionó.
		Antes de eso funcionaba correctamente.

	