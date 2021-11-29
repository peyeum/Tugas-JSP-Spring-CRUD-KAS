<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="https://stmik.ipem.ac.id/stmik/img/logo.png"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<style>
    *,*::before,*::after {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    .app {
        display: grid;
        height: 100vh;
        overflow: hidden;
        grid-template-columns: 20vw 1fr;
        grid-template-rows: max(15vh,100px);
    }

    header {
        grid-column: 1/3;
        display: grid;
        align-items: center;
        grid-template-columns: 1fr 10vw;
    }

    main {
        overflow-y: scroll; 
    }

    .custom-card {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        gap: .5rem;
    }

    #particles-js {
        height: 100vh;
        overflow: hidden;
        background-color: #dbd7d2;
    }

    .custom-form {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {
        -webkit-appearance: none;
    } 

    input[type=number] { 
        -moz-appearance: textfield;
    }
</style>