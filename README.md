# mutantsGML
Prueba Tecnica FullStack

- Instalar Postgres y crear la base de datos 'mutants_db'
  Crear la Tabla stats : 
    create table stats(
      id serial primary key,
      count_human_dna int,
      count_mutant int
    );
  Inserta la siguiente fila en la tabla stats:
    insert into stats (count_human_dna, count_mutant) values(0,0)
  
- En el Archivo application.properties ubicado en \src\main\resources colocar su usuario y contraseña de postgres

- Clonar el repositorio preferiblemente con el editor Intellij idea e instalar dependencias, y ejecutar

- Abrir Postman crea una solicitud tipo POST y coloca la URL localhost:8080/mutant, en Body selecciona raw y el formato Json y agrega la siguiente matriz:
  { “dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}
  Y le da enviar la api respondera si es mutante 200 OK: 
    Mutante Encontrado !! 
      DNA Encontrados Vertical: 0, DNA Encontrados Horizontal: 0, DNA Encontrados Diagonal: 1
  Si no es mutante respondera  403 Forbidden:
    Humano Encontrado !!
- Para las estadisticas crea una solicitud tipo GET y coloca la URL localhost:8080/stats y le da enviar
  Le respondera con algo similar a esto: 
    {
      "id": 1,
      "countHumanDna": 4, // Cantidad de humanos detectados
      "countMutant": 45, // Cantidad de mutantes detectados
      "ratio": 11.25 // Proporción de mutantes sobre humanos 
    }
    
    Gracias por la atencion
