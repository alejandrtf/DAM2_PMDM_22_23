import { Component } from '@angular/core';

@Component({
  selector: 'app-formulario-usuario',
  templateUrl: './formulario-usuario.component.html',
  styleUrls: ['./formulario-usuario.component.css']
})
export class FormularioUsuarioComponent {
  nombre!: string;
  ciudad!: string;
  isEstudiando: boolean = true;
  empleo!: string;
  edad!: string;



  /** Método que se ejecuta cuando cambie el valor del <input> donde se escribe el nombre y se pulse INTRO
   *  o bien se haga click en otra parte de la pantalla.
   */
  onNombreCambiado(nombreEscrito: string) {
    this.nombre = nombreEscrito;
  }


  /** Método que se ejecuta cuando cambie el valor del <input> donde se escribe la ciudad y se pulse INTRO
 *  o bien se haga click en otra parte de la pantalla.
 */
  onCiudadCambiada(evento: Event) {
    /* El target es el elemento sobre el que sucedió el evento. En nuestro caso en un <input>
     El tipo de los <input> en Javascript es HTMLInputElement
     Por tanto, hay que castear ese target a HTMLInputElement para recoger la propiedad "value" que
     es la que contiene el valor escrito en dicho <input>
     */
    let target: EventTarget | null = evento.target;
    this.ciudad = (target as HTMLInputElement).value;

  }

  /** Método que se ejecuta cuando se escribe algo en el <input> que recoge la edad. Se recoge con el
   *  evento (input) que salta cada vez que se escribe un caracter en el cuadro de texto.
  */
  onEdadCambiada(edad: string) {
    this.edad = edad;
    let parrafo: HTMLElement | null = document.getElementById('edadUsuario');
    if (parrafo != null) {
      parrafo.textContent = edad;

    }

  }

  /** Método que se ejecuta cuando cambia el valor de alguno de los 2 input radio que hay (estudia,trabaja)
   *  
   */
  onInputRadioElegido(opcionElegida: string) {
    if (opcionElegida.toUpperCase() === "ESTUDIA")
      this.isEstudiando = true;
    else this.isEstudiando = false;
  }

  /** Método que se ejecuta al pulsar el botón enviar */
  onClickadoEnviar() {
    alert(`Nombre: ${this.nombre}
    Ciudad: ${this.ciudad}
    Empleo: ${this.empleo}
    Edad: ${this.edad}
    ${this.isEstudiando ? 'Está estudiando' : 'Está trabajando'}`);


  }


}


