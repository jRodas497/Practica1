/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1_00389;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Usuario
 */
public class Practica1_00389 {

    static String company = "Jordi's Race";
    static Scanner sc = new Scanner(System.in);
    static String[][] car = new String[20][7];
    static String[][] user = new String[20][3];
    static String[][] renta = new String[20][10];
    
    static int[] disc = new int[20];
    static int[] days = new int[20];
    
    
    static String usuario;
    static String password;
    static int tipo;
    
    static String newClientNit;
    static String newClientName;
    static String newClientLastName;
            
    public static void main(String[] args) {
        
        user[0][0] = 0+"";
        user[0][1] = "admin_00389";
        user[0][2] = "admin_00389";
        
        /*
        user[0][0] = 0+"";
        user[0][1] = "admin";
        user[0][2] = "admin";
        */
        
        user[1][0] = "113304226";
        user[1][1] = "Juan";
        user[1][2] = "Rodas";
        
        user[2][0] = "12345678";
        user[2][1] = "José";
        user[2][2] = "Mansilla";
        
        user[3][0] = "147852369";
        user[3][1] = "Kylian";
        user[3][2] = "Mbappe";
        
        car[0][0] = "Toyota";
        car[0][1] = "Yaris";
        car[0][2] = "2003";
        car[0][3] = "P123ABC";
        car[0][4] = "255";
        car[0][5] = "Si";
        car[0][6] = "Vacío";
        
        car[1][0] = "Toyota";
        car[1][1] = "Supra";
        car[1][2] = "2022";
        car[1][3] = "P999ZZZ";
        car[1][4] = "500";
        car[1][5] = "Si";
        car[1][6] = "Vacío";
        
        car[2][0] = "Mitshubishi";
        car[2][1] = "Lancer";
        car[2][2] = "2017";
        car[2][3] = "P497JJJ";
        car[2][4] = "379";
        car[2][5] = "Si";
        car[2][6] = "Vacío";
        
        days[0] = 15;
        disc[0] = 19;
        
        days[1] = 20;
        disc[1] = 27;
        
        days[2] = 10;
        disc[2] = 5;

        do {
            
            System.out.println("•••Bienvenido a nuestra arrendadora de automóviles•••");
            System.out.println("1. Ingresar como administrador");
            System.out.println("2. Ingresar como cliente");
            System.out.println("3. Registrarse por primera vez");
            System.out.println("4. Finalizar proyecto");

            tipo = sc.nextInt();
            System.out.println("");
            
            switch(tipo){

                case 1 -> {
                    System.out.println("Usuario:");
                    usuario = sc.next();
                    System.out.println("");
                    System.out.println("Contraseña:");
                    password = sc.next();

                    adminMenu(usuario, password);                  
                }
                case 2 -> {
                    
                    String nitUser;
           // Comprobar si el usuario se registra por primera vez o iniciar sesión
                    System.out.println("Número de Nit:");
                    
                    nitUser = sc.next();
                    System.out.println("");
                    
                    clienteMenu(nitUser);               
                }
                case 3 -> {

                    System.out.println("+++Nuevo registro de cliente+++");
                    System.out.println("");
                    System.out.println("Ingresa tu nit");
                    newClientNit = sc.next();
                    System.out.println("");
                    System.out.println("Ingresa tu primer nombre");
                    newClientName = sc.next();
                    System.out.println("");
                    System.out.println("Ingresa tu primer apellido");
                    newClientLastName = sc.next();
                    System.out.println("");
                    
                    addClient(newClientNit,newClientName,newClientLastName);
                    
                }
                default -> {
                    System.out.println("Lo siento, opción no valida :(");
                    System.out.println("Vuelve a intentar");  
                    System.out.println("");
 
                }
            }
            
        }while(tipo != 4);
    }
       
    public static void addCar(int option){
        String nameCar;
        String nameBrand;
        String modelCar;
        String plateCar;
        String priceCar;
        String stateCar;
        
        if (option == 1){
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
//            System.out.println("Marca | Línea | Modelo | Placa | Coste diario | Estado");
            System.out.printf("|%5s|%12s|%12s|%12s|%12s|%15s|%12s|%12s|%n","ID","Marca","Línea","Modelo","Placa","Coste x día Q.","Disponible","Nit");
            for(int i = 0; i < car.length; i++){
            
                if(car[i][0] != null){
                    System.out.printf("|%5s|%12s|%12s|%12s|%12s|%15s|%12s|%12s|%n",i+1,car[i][0],car[i][1],car[i][2],car[i][3],car[i][4],car[i][5],car[i][6]);
                    
                }
                
            }
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("");
        }else if(option == 2){

            boolean plateExist = false;
            int count = 0;
            
            System.out.println("Marca del auto:");
            nameCar = sc.next();
            System.out.println("");
            System.out.println("Linea del auto:");
            nameBrand = sc.next();
            System.out.println("");
            System.out.println("Modelo del auto:");
            modelCar = sc.next();
            System.out.println("");
            System.out.println("Placa del auto:");
            plateCar = sc.next();
            System.out.println("");
            System.out.println("Coste diario de alquiler:");
            priceCar = sc.next();
            System.out.println("");
            
            for(int i = 0; i < car.length; i++){
            
                if(car[i][0] != null){
                    
                    count ++;
                    if(car[i][3].equalsIgnoreCase(plateCar)){
                    
                        plateExist = true;
                        
                    }
                }else{
                    
                    if(plateExist == false) {
                        
                        double cost = Double.parseDouble(priceCar);
                        
                        if(cost > 0){
                        
                            car[i][0] = nameCar;
                            car[i][1] = nameBrand;
                            car[i][2] = modelCar;
                            car[i][3] = plateCar.toUpperCase();
                            car[i][4] = priceCar;
                            car[i][5] = "Si";
                            car[i][6] = "Vacío";
                            

                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            System.out.println("Carro añadido!");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            System.out.println("");
                            i = car.length;
                            
                        }else{
                            System.out.println("El precio de alquiler debera ser mayo a 0");
                            System.out.println("");
                            i = car.length;
                            
                        }
                    }else{
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
                        System.out.println("La placa ya se encuentra agregada");
                        System.out.println("Por lo que el carro no sera añadido");
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
                        System.out.println("");
                        i = car.length;
                        
                    }
                }
                
                if(count == car.length){
                    System.out.println("");
                    System.out.println("Se llego al límite de carros por añadir");
                }
                
            }
        }else if(option == 2){

            boolean plateExist = false;
            int count = 0;
            
            System.out.println("");
            System.out.println("Marca del auto:");
            nameCar = sc.next();
            System.out.println("Linea del auto:");
            nameBrand = sc.next();
            System.out.println("Modelo del auto:");
            modelCar = sc.next();
            System.out.println("Placa del auto:");
            plateCar = sc.next();
            System.out.println("Coste diario de alquiler:");
            priceCar = sc.next();
            
            for(int i = 0; i < car.length; i++){
            
                if(car[i][0] != null){
                    
                    count ++;
                    if(car[i][3].equalsIgnoreCase(plateCar)){
                    
                        plateExist = true;
                        
                    }
                }else{
                    
                    if(plateExist == false) {
                        
                        double cost = Double.parseDouble(priceCar);
                        
                        if(cost > 0){
                        
                            car[i][0] = nameCar;
                            car[i][1] = nameBrand;
                            car[i][2] = modelCar;
                            car[i][3] = plateCar.toUpperCase();
                            car[i][4] = priceCar;
                            car[i][5] = "Si";
                            car[i][6] = "Vacío";
                            

                            System.out.println("");
                            System.out.println("Carro añadido!");
                            i = car.length;
                            
                        }else{
                        
                            System.out.println("");
                            System.out.println("El precio de alquiler debera ser mayo a 0");
                            i = car.length;
                            
                        }
                    }else{
                        System.out.println("");
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
                        System.out.println("La placa ya se encuentra agregada");
                        System.out.println("Por lo que el carro no sera añadido");
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
                        i = car.length;
                        
                    }
                }
                
                if(count == car.length){
                    System.out.println("");
                    System.out.println("Se llego al límite de carros por añadir");
                }
                
            }
        }else if(option == 2){

            boolean plateExist = false;
            int count = 0;
            
            System.out.println("");
            System.out.println("Marca del auto:");
            nameCar = sc.next();
            System.out.println("Linea del auto:");
            nameBrand = sc.next();
            System.out.println("Modelo del auto:");
            modelCar = sc.next();
            System.out.println("Placa del auto:");
            plateCar = sc.next();
            System.out.println("Coste diario de alquiler:");
            priceCar = sc.next();
            
            for(int i = 0; i < car.length; i++){
            
                if(car[i][0] != null){
                    
                    count ++;
                    if(car[i][3].equalsIgnoreCase(plateCar)){
                    
                        plateExist = true;
                        
                    }
                }else{
                    
                    if(plateExist == false) {
                        
                        double cost = Double.parseDouble(priceCar);
                        
                        if(cost > 0){
                        
                            car[i][0] = nameCar;
                            car[i][1] = nameBrand;
                            car[i][2] = modelCar;
                            car[i][3] = plateCar.toUpperCase();
                            car[i][4] = priceCar;
                            car[i][5] = "Si";
                            car[i][6] = "Vacío";
                            

                            System.out.println("");
                            System.out.println("Carro añadido!");
                            i = car.length;
                            
                        }else{
                        
                            System.out.println("");
                            System.out.println("El precio de alquiler debera ser mayo a 0");
                            i = car.length;
                            
                        }
                    }else{
                        System.out.println("");
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
                        System.out.println("La placa ya se encuentra agregada");
                        System.out.println("Por lo que el carro no sera añadido");
                        System.out.println("*-*-*-*-*-*-*-*-*-*-*");
                        i = car.length;
                        
                    }
                }
                
                if(count == car.length){
                    System.out.println("");
                    System.out.println("Se llego al límite de carros por añadir");
                }
                
            }
        }
    }
    
    public static void addDiscount(int option){
        int daysDisc;
        int percentage;
    
        if(option == 1){

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
//                                    System.out.println("Días mínimos  |  Porcentaje");
            System.out.printf("|%12s|%12s|%n","Días mínimos", "Porcentaje %");
                for(int i = 0; i < days.length; i++){

                    if(days[i] != 0){

                        System.out.printf("|%12s|%12s|%n",days[i],disc[i]);

                    }                
                }
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("");
        }else if(option == 2){

            boolean discExist = false;
            int count = 0;

            System.out.println("*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Días mínimos de alquiler");
            daysDisc = sc.nextInt();
            System.out.println("");
            System.out.println("Porcentaje de descuento");
            percentage = sc.nextInt();
            System.out.println("");

            for(int i = 0; i<days.length; i++){

                if(days[i] != 0){
                    count++;

                    if(days[i] == daysDisc){
                        discExist = true;
                    }

                }else{

                    if(discExist == false){

                        if(daysDisc < 1){
                            System.out.println("");
                            System.out.println("La cantidad de días deben de ser mayores a 0");
                        }else{
                            if(percentage <1 || percentage >100){
                                System.out.println("");
                                System.out.println("El porcentaje debe de:");
                                System.out.println("Ser mayor de 0 y menor a 100");
                                i = disc.length;

                            }else{

                                days[i] = daysDisc;
                                disc[i] = percentage;
                                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                                System.out.println("Descuento especial añadido!");
                                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                                System.out.println("");
                                i = days.length;

                            }
                        }

                    }else{
                        System.out.println("");
                        System.out.println("Ya existe un descuento con esta cantidad de días");
                        i = disc.length;
                    }
                }
                if(count == days.length){
                    System.out.println("");
                    System.out.println("Se llego al número máximo de descuentos");
                }
            }
        }
    }
    
    public static void client(int option){
        String nit;
        String name;
        String lastName;       
        
        if(option == 1){

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.printf("|%5s|%12s|%12s|%12s|%n", "ID","Nit", "Nombre", "Apellido");
                for(int i = 0; i < user.length; i++){

                    if(user[i][0] != null){
                        System.out.printf("|%5s|%12s|%12s|%12s|%n",i+1,user[i][0],user[i][1],user[i][2]);
                    }                
                }
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("");
        }else if(option == 2){

            System.out.println("*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Nit:");
            nit = sc.next();
            System.out.println("");
            System.out.println("Primer nombre:");
            name = sc.next();
            System.out.println("");
            System.out.println("Primer apellido:");
            lastName = sc.next();
            System.out.println("");

            addClient(nit, name, lastName);
            
        }
    }
    
    public static void addClient(String nit, String name, String lastName){
        boolean nitExist = false;
        int count = 0;
        
        for(int i = 0; i<days.length; i++){

            if(user[i][0] != null){
                count++;

                if(user[i][0].equalsIgnoreCase(nit+"")){
                    nitExist = true;
                }

            }else{

                if(nitExist  == false){

                    if(nit == 0+""){
                        System.out.println("El nit no puede ser menor o igual a 0");
                        System.out.println("");
                    }else{


                            user[i][0] = nit+"";
                            user[i][1] = name;
                            user[i][2] = lastName;
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            System.out.println("Usuario registrado con éxito!");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            System.out.println("");
                            i = user.length;

                    }

                }else{
                    System.out.println("Ya existe un cliente con este Nit");
                    System.out.println("");
                    i = user.length;
                }
            }
            if(count == user.length){
                System.out.println("Se llego al número máximo de clientes");
                System.out.println("");
            }
        }
    }
    
    public static void adminMenu(String user, String pass){
        String user_admin = "admin";
        String pass_admin = "admin";
        int option;
        int close;
    
        if(user.equals(user_admin) && password.equals(pass_admin)){
            System.out.println("");
            System.out.println("Bienvenido " + usuario + "!");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("");

            do{
                System.out.println("+++Administrador+++");
                System.out.println("");
                System.out.println("1. Vehiculos");
                System.out.println("2. Descuentos");
                System.out.println("3. Usuarios");
                System.out.println("4. Generar reportes");
                System.out.println("5. Cerrar sesión");

                option = sc.nextInt();
                System.out.println("");

                switch(option){
                    case 1 -> {
                        int case1Answer;

                        do{
                            System.out.println("•••Opciones•••");
                            System.out.println("1. Listado de vehiculos");
                            System.out.println("2. Agregar vehiculo");
                            System.out.println("3. Editar datos del vehiculo");
                            System.out.println("4. Eliminar vehiculo");
                            System.out.println("5. Si desea hacer otra operación");

                            case1Answer = sc.nextInt();
                            System.out.println("");

                            switch(case1Answer){
                                case 1 -> {
                                    addCar(case1Answer);
                                }
                                case 2 -> {
                                    addCar(case1Answer);
                                }
                                case 3 -> {
                                    editCar();
                                }
                                case 4 -> {
                                    eliminateCar();
                                }
                            }
                                

                        } while (case1Answer != 5);

                    }
                    case 2 -> {
                        int case2Answer;

                        do{
                            System.out.println("•••Opciones•••");
                            System.out.println("1. Descuentos existentes");
                            System.out.println("2. Agregar descuento");
                            System.out.println("3. Si desea hacer otra operación");

                            case2Answer = sc.nextInt();
                            System.out.println("");

                            addDiscount(case2Answer);

                        } while (case2Answer == 1 || case2Answer == 2);
                    }
                    case 3 -> {
                        int case3Answer;

                        do{
                            System.out.println("•••Opciones•••");
                            System.out.println("1. Clientes registrados");
                            System.out.println("2. Agregar usuario");
                            System.out.println("3. Si desea hacer otra operación");

                            case3Answer = sc.nextInt();
                            System.out.println("");

                            client(case3Answer);

                        }while(case3Answer == 1 || case3Answer == 2);
                    }
                    
                    case 4 -> {
                        int case4Answer;
                        
                        
                    }
                    
                    case 5 -> {
//                        int case5Answer = 0;
//                        System.out.println("");
//                        System.out.println("Está seguro de regresar al menú principal?");
//                        System.out.println("Escriba 1 si desea hacer otra operación");
//                        System.out.println("Escriba 2 si desea cerrar sesión");
//
//
//                        close = sc.nextInt();
//                        close1 = 1;
//                        System.out.println("");
//                        close = 0;

                    }
                    default -> {

                        System.out.println("Lo siento, opción no valida :(");
                        System.out.println("Vuelve a intentar");                        
                        System.out.println("");
                    }
                }

                System.out.println("Desea hacer otra operación en el menú principal?");
                System.out.println("1. Realizar hacer otra operación");
                System.out.println("2. Cerrar sesión");

                close = sc.nextInt();
                System.out.println("");

            } while(close == 1);       
        }else{
            System.out.println("");
    System.out.println("Oops!");
    System.out.println("Parece que tu usario o contraseña son incorrectos");
    System.out.println("Vuelve a intentar");
    System.out.println("");
        }
        
    }
  
    public static void clienteMenu(String nit){
        String nitUsuario;
        String nameUsuario;
        String lastNameUsuario;
        int option = 0;
        int count = 0;
        int carOption;
        int cantDays;
        
        for(int i = 0; i < user.length; i++){
           count++;
            
            if(nit.equalsIgnoreCase(user[i][0])){
            
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Bienvenido " + user[i][1] + " " + user[i][2] + "!");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("");
                
                nitUsuario = user[i][0];
                nameUsuario = user[i][1];
                lastNameUsuario = user[i][2];
                
                do{
                    System.out.println("+++Cliente+++");
                    System.out.println("");
                    System.out.println("1. Realizar orden de Renta de vehiculos");
                    System.out.println("2. Ver vehiculos registrados");
                    System.out.println("3. Finalizar renta de un auto");
                    System.out.println("4. Cerrar sesión");

                    option = sc.nextInt();
                    System.out.println("");
                    
                    i = user.length;
                    
                    switch(option){
                        case 1 -> {
                            
                            System.out.println("Aqui tienes un resumen nuestros vehiculos"); 
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            System.out.printf("|%5s|%12s|%12s|%15s|%12s|%12s|%n","ID","Marca","Línea","Modelo","Coste x día Q.","Disponible");
                            for(int k = 0; k < car.length; k++){

                                if(car[k][0] != null){
                                    System.out.printf("|%5s|%12s|%12s|%12s|%15s|%12s|%n",k+1,car[k][0],car[k][1],car[k][2],car[k][4],car[k][5]);

                                }

                            }
                            
                            addDiscount(1);
                            
                            System.out.println("Ingresa el ID del vehiculo que desees:");
                            carOption = sc.nextInt();
                            System.out.println("");
                            System.out.println("Ingresa la cantidad de días que lo rentaras:");
                            cantDays = sc.nextInt();
                            System.out.println("");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            
                            rent(carOption, nitUsuario, nameUsuario, nameUsuario, cantDays);
                            
                        }
                        case 2 -> {
                            listRenta(nitUsuario);
                        }
                        case 3 -> {
                            endRent(nitUsuario);
                        }
                        case 4 -> {
                        
                        }
                        default -> {
                            System.out.println("Lo siento, opción no valida :(");
                            System.out.println("Vuelve a intentar"); 
                            System.out.println("");
                        }
                    }                    
                }while(option != 4);
            }else{
                if(count == user.length){
                    System.out.println("Oops!");
                    System.out.println("Parece que tu Nit es incorrecto");
                    System.out.println("Vuelve a intentar");
                    System.out.println("");
                }
            }
        }
    }
    
    public static void rent(int idCar, String nit, String name, String lastName, int diasY){
        int count = 0;
        String YN;
        double decimalDay;
        double decimalMonth;
        int entDay;
        int entMonth;       
        double decimalMinut;
        double decimalHour;
        int entMinut;
        int entHour;
        int max = 0;
        
        for(int k = 0; k<car.length; k++){            
            count ++;
            if(count == car.length || idCar >= 20 || idCar <= 0){
                System.out.println("ID de vehiculo no valido");
                System.out.println("Vuelve a intentar");
                System.out.println("");

                k = car.length;
                
            }else if(car[idCar - 1][5] == "Si" && car[idCar - 1][0] != null && car[k][3] == car[idCar -1][3]){
                car[k][5] = "No";
                car[k][6] = nit;
                
                k = car.length;

                System.out.println("Vehiculo rentado con éxito!");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("");
                System.out.println("•••REPORTE DE LA RENTA ACTUAL•••");
                System.out.println("");
                
                System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                System.out.println("Nombre de la Empresa: " + company);
                System.out.println("Nombre del cliente:");
                System.out.println(name + " " + lastName);
                System.out.println("Número de Nit del cliente:");
                System.out.println(nit);
                System.out.println("Fecha y hora de la factura:");

                do{
                    decimalDay = Math.random()*30;
                    entDay = (int) decimalDay;

                    decimalMonth = Math.random()*12;
                    entMonth = (int) decimalMonth;

                }while(entDay < 0 && entDay > 29 && entMonth < 0 && entMonth > 13/* && entYear < 0 && entYear > 5*/);

                if(entDay == 0){
                    entDay = entDay + 5;
                }else if(entMonth == 0){
                    entMonth = entMonth + 5;
                }

                System.out.println(entDay + "/" + entMonth + "/" + 2023);

                do{            
                    decimalMinut = Math.random()*54;
                    entMinut = (int) decimalMinut;

                    decimalHour = Math.random()*22;
                    entHour = (int) decimalHour;

                }while(entMinut != 0 && entMinut > 60 && entHour != 0 && entHour > 24);

                if(entMinut == 0){
                    entMinut = entMinut + 5;
                }else if(entHour == 0){
                    entHour = entHour + 10;
                }

                System.out.println("A las " + entHour + " horas con " + entMinut + " minutos");
                System.out.println("");


                System.out.println("Listado de vehiculos rentados");

                String dias = diasY + "";
                String date = entDay + "/" + entMonth + "/" + 2023;
                String hour = entHour + " : " + entMinut;

                addRenta(nit, car[idCar - 1][0], car[idCar - 1][1], dias, date, car[idCar - 1][3], car[idCar - 1][4]);

                listRenta(nit);
                System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                System.out.println("");
                System.out.println("Si deseas ver de nuevo tus vehiculos registrados podras verlos");
                System.out.println("En el apartado de vehiculos registrados");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("");
                
            }
        }
    }
   
    public static void addRenta(String nit, String marca, String linea, String dias, String fecha, String placa, String precio){
        int count = 0;
        int max = 0;
        int diasCant = Integer.parseInt(dias);
        int diasPrice = Integer.parseInt(precio);
        int descuento = 0;
        double resta = 0;
        
        double total = diasCant * diasPrice;
        
        for(int i = 0; i < days.length; i++){
            if(days[i] == 0){
                i = days.length;
            }else if(days[i] <= diasCant){

                if (max <= days[i]) {
                    max = days[i];
                }
            }
        }
        
        for (int i = 0; i < days.length; i++) {
            if (max == days[i]) {
                descuento = disc[i];
                i = days.length;
            }
        }
        
        
//            if(max == 0){
//                descuento = 0;
//                subTotal = total - (total * (descuento*(1/100)));    
//            }
//            if (descuento != 0){
//                subTotal = total - (total * (descuento*(1/100)));
//            }
            double discount = (100 - descuento)*0.01;
        
        for(int i = 0; i <= renta.length; i++){
            if(renta[i][0] != null){
                count ++;
            }else{
                renta[i][0] = nit;
                renta[i][1] = marca;
                renta[i][2] = linea;
                renta[i][3] = dias;
                renta[i][4] = fecha;
                renta[i][5] = placa;
                renta[i][6] = "Q." + total + "";     
                renta[i][7] = descuento + "%";     
                renta[i][8] = "Q." + total * discount + "";     
                renta[i][9] = "Acte en uso";     
                
                i = renta.length;
            }
        }
    }
    
    public static void listRenta(String nit){
        int count = 0;
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.printf("|%5s|%12s|%12s|%12s|%9s|%12s|%12s|%25s|%12s|%n","ID","Marca","Línea","Placas","Días","Sub Total","Descuento","Total","Fin de uso");
        for(int k = 0; k < renta.length; k++){
            count ++;

            if(renta[k][0] == nit){
                System.out.printf("|%5s|%12s|%12s|%12s|%9s|%12s|%12s|%25s|%12s|%n", k + 1,renta[k][1],renta[k][2],renta[k][5],renta[k][3],renta[k][6],renta[k][7],renta[k][8],renta[k][9]);
                
            }else if(count == renta.length){
                System.out.println("");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Sin registros adicionales");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("");
                k = renta.length;
            }
        }
    }
    
    public static void editCar(){
        String nameCar;
        String nameBrand;
        String modelCar;
        String priceCar;
        
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
//      System.out.println("Marca | Línea | Modelo | Placa | Coste diario | Estado");
        System.out.printf("|%5s|%12s|%12s|%12s|%12s|%15s|%12s|%12s|%n","ID","Marca","Línea","Modelo","Placa","Coste x día Q.","Disponible","Nit");
        for(int i = 0; i < car.length; i++){

            if(car[i][0] != null){
                System.out.printf("|%5s|%12s|%12s|%12s|%12s|%15s|%12s|%12s|%n",i+1,car[i][0],car[i][1],car[i][2],car[i][3],car[i][4],car[i][5],car[i][6]);

            }

        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("");
        System.out.println("Ingresa el ID del vehiculo por editar");
        int idCar = sc.nextInt();
        System.out.println("");
        
        if (idCar < 0 || idCar > 20 || car[idCar - 1][0] == null) {
            System.out.println("ID de vehiculo no valido");
            System.out.println("Vuelve a intentar");
            System.out.println("");
        }else{
            if (car[idCar - 1][5] == "Si" && car[idCar - 1][6] == "Vacío") {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Marca del auto:");
                nameCar = sc.next();
                System.out.println("");
                System.out.println("Linea del auto:");
                nameBrand = sc.next();
                System.out.println("");
                System.out.println("Modelo del auto:");
                modelCar = sc.next();
                System.out.println("");
                System.out.println("Coste diario de alquiler:");
                priceCar = sc.next();
                System.out.println("");
                
                double cost = Double.parseDouble(priceCar);
                
                if (cost > 0) {
                    car[idCar - 1][0] = nameCar;
                    car[idCar - 1][1] = nameBrand;
                    car[idCar - 1][2] = modelCar;
                    car[idCar - 1][4] = priceCar;
                    
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    System.out.println("Carro editado con éxito!");
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    System.out.println("");
                }else{
                    System.out.println("El precio de alquiler debera ser mayo a 0");
                    System.out.println("");
                }
                
            }else{
                System.out.println("El vehiculo se encuentra actualmente en uso");
                System.out.println("Vuelve a intentar en un rato");
                System.out.println("");
            }
        }
    }
    
    public static void eliminateCar(){
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.printf("|%5s|%12s|%12s|%12s|%12s|%15s|%12s|%12s|%n","ID","Marca","Línea","Modelo","Placa","Coste x día Q.","Disponible","Nit");
        for(int i = 0; i < car.length; i++){

            if(car[i][0] != null){
                System.out.printf("|%5s|%12s|%12s|%12s|%12s|%15s|%12s|%12s|%n",i+1,car[i][0],car[i][1],car[i][2],car[i][3],car[i][4],car[i][5],car[i][6]);
            }
        }
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("");
        System.out.println("Ingresa el ID del vehiculo por eliminar");
        int idCar = sc.nextInt();
        System.out.println("");
        
        if (idCar < 0 || idCar > 20 || car[idCar - 1][0] == null) {
            System.out.println("");
            System.out.println("ID de vehiculo no valido");
            System.out.println("Vuelve a intentar");
        }else{
            if (car[idCar - 1][5].equals("Si") && car[idCar - 1][6].equals("Vacío")) {

                    car[idCar - 1][0] = "Eliminado";
                    car[idCar - 1][1] = "Eliminado";
                    car[idCar - 1][2] = "Eliminado";
                    car[idCar - 1][4] = "Eliminado";
                    
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    System.out.println("Carro eliminado con éxito!");
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    System.out.println("");
                                
            }else{
                System.out.println("El vehiculo se encuentra actualmente en uso");
                System.out.println("Vuelve a intentar en un rato");
                System.out.println("");
            }
        }
    }
    
    public static void endRent(String nit){
        String dateTime = DateTimeFormatter.ofPattern("dd MMM yyyy").format(LocalDateTime.now());
        int count = 0;
        boolean valid = true;
        
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.printf("|%5s|%12s|%12s|%12s|%12s|%15s|%12s|%12s|%n","ID","Marca","Línea","Modelo","Placa","Coste x día Q.","Disponible","Nit");
        
        for(int i = 0; i < car.length; i++){
            count++;
            if(car[i][6] == (nit)){
                System.out.printf("|%5s|%12s|%12s|%12s|%12s|%15s|%12s|%12s|%n",i+1,car[i][0],car[i][1],car[i][2],car[i][3],car[i][4],car[i][5],car[i][6]);
            }else if(count == car.length){
                System.out.println("");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Sin registros adicionales");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("");
            }
        }
        
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("");
        
        if (valid) {
            System.out.println("Ingresa el ID del vehiculo por terminar la renta");
            int idCar = sc.nextInt();
            System.out.println("");

            if (idCar < 0 || idCar > 20 || car[idCar - 1][0] == null) {
                System.out.println("ID de vehiculo no valido");
                System.out.println("Vuelve a intentar");
                System.out.println("");
            }else{
                for (int i = 0; i < renta.length; i++) {
                    if(renta[i][0] == nit){

                        if (car[idCar - 1][6] == nit) {

                            car[idCar - 1][6] = "Vacío";
                            car[idCar - 1][5] = "Si";

                            renta[i][9] = dateTime + "";
                            
                            System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                            System.out.println("¡Muchas gracias por confiar en nuestros servicios!");
                            System.out.println("Arrendadora de autos " + company + " te lo agradece <3");
                            System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                            System.out.println("");
                        }


                i = renta.length;
                    }else{
                        System.out.println("");
                        System.out.println("Parece que aún no tienes vehiculos en renta");
                        System.out.println("Registra uno para luego cancelar la renta");

                        i = renta.length;
                    }
                }
            }
        }        
    }
}   