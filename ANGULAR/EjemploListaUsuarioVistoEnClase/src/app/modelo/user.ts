export class User {
    /* nombre: string;
     edad: number;
     trabaja: boolean;
 
     constructor(nombre: string, edad: number, trabaja: boolean) {
         this.nombre = nombre;
         this.edad = edad;
         this.trabaja = trabaja;
 
     }*/

    constructor(
        public nombre: string,
        public edad: number,
        public trabaja: boolean
    ) { }


    isMayorEdad(): boolean {
        return this.edad >= 18 ? true : false;
    }
}
