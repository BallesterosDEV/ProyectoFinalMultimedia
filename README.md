# Super Mario Bros API
### 1 - Introducción
Esta aplicación creada con Android Studio (SDK = 34) en Java pretende hacer un CRUD sobre la entidad `Personajes` de Mario Bros, estos personajes tienen diferentes atributos (id, nombre, raza, altura y peso). A través de los diferentes fragments a los que se accede por un menú de navegación se pueden realizar todas las operaciones del crud. Para poder realizar los métodos del CRUD, utilizo SQLite como base de datos.

### 2 - Login
Lo primero es crear nuestra aplicación es mostrar una ventana por la que el usuario pueda loguearse, para ello, he seguido los siguientes pasos:
- Crear el diseño de la interfaz, con campos de entrada de texto y contraseña, así como un botón para loguearse. He incluído algunos estilos menores como un fondo de pantalla para la aplicación, así como una fuente específica y diferentes tonalidades que contrasten con la esencia de Super Mario.

  ![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/13e6b5bc-bddc-4b0c-b804-45a79fcaa0cb)

- Crear la clase java relacionada con el archivo xml de la interfaz, que busca en la base de datos un usuario y contraseña que coincidan con los que se han introducido en los campos de entrada, notificando al usuario por medio de toasts sobre el éxito o fracaso del login. De momento vamos a tener un acto de fe y creernos que por alguna parte hay una base de datos con una tabla `usuarios` que contenga el nombre de usuario y la contraseña.
  
![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/72dbf3ee-719a-427c-8c0b-edf8c01e1b0d)

### 3 - Main Activity 
Una vez el usuario se loguea correctamente, pasamos a la actividad principal, en ella incluiremos el menú de navegación inferior por el que accederemos a los diferentes fragments, los elementos de la actividad principal nunca desaparecerán aunque te desplaces por los diferentes fragments, así que solo incluiremos el menú y el mismo fondo de pantalla.

![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/806e61b0-ce87-4bed-84c3-109d5c7b1d78)

- La actividad principal contiene por defecto el fragment home que se encargará de mostrar la lista de todos los personajes de Super Mario, más adelante veremos cómo funciona ese fragment, de momento, vamos a centrarnos en el menú de navegación inferior, para crear un menú de navegación necesitaremos varios archivos, entre ellos el `nav_graph.xml`, que por así decirlo contiene el host de navegación, también necesitaremos el archivo `bottom_navigation_menu.xml` que contendrá el menú con sus respectivos iconos (yo he importado imágenes propias relacionadas con el universo de Super Mario). Es muy importante incluir el host de navegación en el archivo xml de la actividad principal para que se sepa que ese es el menú de navegación:
  
![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/2d5bc01b-c049-4b67-bb03-986575f161a7)

![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/cfc9507a-b996-44a3-af03-49cee00b2ab6)

- Por último, manejamos la forma en la que el usuario va interactuando con el menú de navegación:

![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/887c2b76-4fc3-4cc0-9be3-a009bee0f43e)

### 4 - SQLite
La clase SQLiteOpenHelper nos va a ayudar a hacer tanto las operaciones del CRUD como a loguearnos correctamente, al implementar los métodos y constructores que pide, podremos utilizar dicha clase para crear nuestra base de datos e insertar los datos que deseamos, en mi caso, en el método `onCreate`

![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/12aefe8e-67df-4e51-80f8-502755bade78)

![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/dbd2951f-4ec0-4ab8-9e84-0d1046c6e3df)

También hemos necesitado crear la clase `Characters` y la clase `CharacterAdapter` para poder realizar las operaciones del CRUD.

### 5 - Fragments
- **Fragment Home:** Aquí mostraremos la lista de personajes, para ello utilizaremos un `RecicleView` que mostrará la lista de personajes:
![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/2c633911-6e4c-483c-b489-b4c1eafd78e8)

- **Fragment Create:** Aquí crearemos los personajes gracias a los datos que introduzca el usuario, el procedimiento es simple, obtenemos la id de los elementos de entrada de texto, posteriormente su contenido, y tras algunas validaciones, creamos el personaje.

![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/168181b7-4946-4348-8353-b0c9695dc5ff)
  
![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/a28ebf1e-fd0a-4b0c-b7bd-6ed8a7e3a3ae)

- **Fragment Edit:** El proceso es prácticamente idéntico, se introducen los mismos datos para editar a excepción de la id, que hará referencia al personaje que se desea editar, ya que la id por buena práctica no debería ser modificable.

![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/df329daa-0780-479b-87e3-1301933e8f6e)

- **Fragment Delete:** En este caso, en la pantalla solo aparecerá un campo para ingresar la id del personaje que deseas eliminar.

![image](https://github.com/BallesterosDEV/ProyectoFinalMultimedia/assets/118269269/142821ce-979c-4799-8980-cdb3c035e020)









