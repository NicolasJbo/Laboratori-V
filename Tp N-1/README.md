# Laboratori-V
El sistema utilizado en el Tp a la hora de competir se basa en agregarles un limite random al vikingo y al espartano(cada uno se le aplica su respectiva "habilidades" ) .Cuando uno de ellos llega a 0 tiene que ir a orinar ,perdiendo el combate.
En caso de haber un Empate ganaria el Vikingo porque es el Favorito del creador del programa.....mejor dicho porque la taberna  fue construida por un grupo de Vikingos. 

---------------------------------------------Preguntas---------------------------------------------


1)¿ Que es Maven ?

Maven es una herramienta de línea de comandos, sin interface gráfica que nos ayuda a crear los directorios de nuestro proyecto y con las tareas habituales que se realizan en él, como compilado, generar jar, documentación, distribuir, dependencias con otros jar, etc.
Es reconocida por ser utilizada en la gestión y construcción de software, sin embargo, la característica más importante de Maven es su capacidad de trabajar en red.Cuando definimos las dependencias de Maven, este sistema se encargará de ubicar las librerías que deseamos utilizar en Maven Central, el cual es un repositorio que contiene cientos de librerías constantemente actualizadas por sus creadores.

2)POM: Qué significa y para que nos sirve

El Project Object Model o más conocido por sus siglas POM es una representación XML de un proyecto Maven que tiene como utilidad ser el lugar en donde se describa el software a construir, sus dependencias de otros módulos y componentes externos, y el orden de construcción de los elementos. Viene con objetivos predefinidos para realizar ciertas tareas claramente definidas, como la compilación del código y su empaquetado.

3)Diferencia entre Archetype y Artifacld

La diferencia es que los Archetype son plantillas de proyectos Maven destinadad a los usuarios para proveer los medios necesarios y generar una version parametrizada de las plantillas
,mientras que ArtifacId es el nombre por el cual identificamos un proyecto Maven y el jar que se genera para el mismo.

4)Explique los siguientes Goals de Maven: clean, package, install, compile.

Un Goal es un comando que recibe Maven como paramtero para hacer algo.

clean: limpia todas las clases compiladas del proyecto.

package: empaqueta el proyecto (si es un proyecto java simple, genera un jar, si es un proyecto web, un war, etc…).

install: instala el artefacto en el repositorio local.

compile: compila el proyecto.



5)Explique los siguientes Scopes: compile, provide, runtime, test, system.

- compile: es la que tenemos por defecto sino especificamos Scope. Indica que la dependencia es necesaria para compilar. La dependencia además se propaga en los proyectos dependientes.
- provide: Es como la anterior, pero esperas que el contenedor ya tenga esa libreria. Un claro ejemplo es cuando desplegamos en un servidor de aplicaciones, que por defecto, tiene bastantes librerías que utilizaremos en el proyecto, así que no necesitamos desplegar la dependencia.
- runtime: La dependencia es necesaria en tiempo de ejecución pero no es necesaria para compilar.
- test: La dependencia es solo para testing que es una de las fases de compilación con maven. Junit es un claro ejemplo de esto.
- system: Es como provide pero tienes que incluir la dependencia explicitamente. Maven no buscará este artefacto en tu repositorio local. Habrá que especificar la ruta de la dependencia mediante la etiqueta
