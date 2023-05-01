import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { FormularioUsuarioComponent } from './formulario-usuario/formulario-usuario.component';




@NgModule({
  declarations: [
    AppComponent,
    FormularioUsuarioComponent
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
