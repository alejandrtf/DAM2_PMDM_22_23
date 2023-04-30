import { Component } from '@angular/core';
import { User } from '../modelo/user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {
  titulo: string = 'Listado de Usuarios';
  usuarios: User[];
  usuarioMayoresEdad!:User[];
  ciudad!:string;

  constructor() {
    this.usuarios = [
      new User('María', 33, true),
      new User('Pedro', 73, false),
      new User('Beatriz', 17, false)
    
    ];
    this.ciudad="madrid";

    this.getMayoresEdad();
  }

  getMayoresEdad():User[]{
    this.usuarioMayoresEdad=this.usuarios.filter(usuario=>usuario.isMayorEdad())
    return this.usuarioMayoresEdad;
  }

  onClickado(){
    alert("me has pulsado");


  }

  onTextoEscrito(texto:string){
    document.getElementsByTagName("p")[1].textContent="Se ha escrito:"+texto;
  }
  onDatosCambiados(input:Event){
    const x=input.target as HTMLInputElement;
    alert(x.value);
   console.log(input);
  
  }
}
