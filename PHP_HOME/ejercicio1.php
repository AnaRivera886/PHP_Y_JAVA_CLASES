<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Ejercico de notas</h1>
        <p>El problema
        Crea una página con un formulario que pida:

        Nombre del estudiante
        3 notas (números decimales)

        Y al enviar debe mostrar:

        El promedio de las 3 notas
        Un mensaje según el promedio:

        90 o más → "Excelente 🏆"
        70 a 89 → "Aprobado ✅"
        50 a 69 → "En riesgo ⚠️"
        Menos de 50 → "Reprobado ❌"


        El nombre del estudiante en el mensaje</p>

        <form action="" method="post" >
            <label for="">Nombre del Estudiante</label>

            <input type="text" name="nombre" id="" placeholder="nombre">
            <br>
            <h3>Notas</h3>
            <label for="">Nota1</label>
            <input type="text" name="nota1" placeholder="Nota 1">
            <label for="">Nota2</label>
            <input type="text" name= "nota2" placeholder="Nota 2">
            <label for="">Nota3</label>
            <input type="text" name= "nota3" placeholder="Nota 3">
            <button type="submit">Promedio</button>

        </form>
</body>
</html>

<?php
    if ($_SERVER["REQUEST_METHOD"] === "POST") {
        $nombre = $_POST["nombre"];
        $nota1 = $_POST["nota1"];
        $nota2 = $_POST["nota2"];
        $nota3 = $_POST["nota3"];
        
        // VALIDACION DE CAMPOS
        if ($nombre === "" || $nota1 === "" || $nota2 === "" || $nota3 === "") {
            $alerta = "<h2>COMPLETA TODOS LOS CAMPOS</h2>";
        }else {
            $nota1 = (float)$nota1;
            $nota2 = (float)$nota2;
            $nota3 = (float)$nota3;

            $promedio = ($nota1 + $nota2 + $nota3) / 3;
            $promedio = number_format($promedio, 2);
            
            if ($promedio >= 90) {
                $alerta = "<h2>EXCELENTE TU SABES MUCHO 🎖</h2>";
                echo $nombre . " tu promedio es: " . $promedio;
            }elseif ($promedio >= 70 && $promedio <= 89) {
                $alerta = "$nombre . <h2>PASASTE YUCA YUCA ✅</h2>";
                echo $nombre . " tu promedio es: " . $promedio;
            }elseif ($promedio >= 50  && $promedio <= 69) {
                $alerta = "<h2>ESTAS EN RIESGO PONTE PILAS</h2>";
                echo $nombre . " tu promedio es: " . $promedio;
            }else {
                $alerta = "<h2>REPROBASTE MIJO RECOJASE</h2>";
                echo $nombre . " tu promedio es: " . $promedio;
            }

            }
        echo $alerta;  
    }  
?>