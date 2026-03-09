<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>dados 3 numeros organizarlos de manera ascendente</h1>

    <form action="" method="post">
        <div>
            <label for="">numero 1</label>
        </div>
        <div>
            <input type="text" name="num1" id="" placeholder="num1">
        </div>
        <div>
            <label for="">numero 2</label>
        </div>
        <div>
            <input type="text" name="num2" id="" placeholder="num2">
        </div>
        <div>
            <label for="">numero 3</label>
        </div>
        <div>
            <input type="text" name="num3" id="" placeholder="num3">
        </div>

        <button type="submit">organizar</button>
    </form>
</body>

</html>
<?php

if ($_SERVER["REQUEST_METHOD"] === "POST") {

    $num1 = $_POST["num1"];
    $num2 = $_POST["num2"];
    $num3 = $_POST["num3"];

    if ($num1 === "" || $num2 === "" || $num3 === "") {
        $mensaje = "<h2>Los campos no pueden estar vacíos.</h2>";
    } else {

        // Convertimos a número (buena práctica)
        $num1 = (float)$num1;
        $num2 = (float)$num2;
        $num3 = (float)$num3;

        if ($num1 <= $num2 && $num1 <= $num3) {
            if ($num2 <= $num3) {
                $mensaje = "Los números ordenados son: $num1, $num2, $num3";
            } else {
                $mensaje = "Los números ordenados son: $num1, $num3, $num2";
            }
        }
        elseif ($num2 <= $num1 && $num2 <= $num3) {
            if ($num1 <= $num3) {
                $mensaje = "Los números ordenados son: $num2, $num1, $num3";
            } else {
                $mensaje = "Los números ordenados son: $num2, $num3, $num1";
            }
        }
        else {
            if ($num1 <= $num2) {
                $mensaje = "Los números ordenados son: $num3, $num1, $num2";
            } else {
                $mensaje = "Los números ordenados son: $num3, $num2, $num1";
            }
        }
    }
}
echo $mensaje;
?>