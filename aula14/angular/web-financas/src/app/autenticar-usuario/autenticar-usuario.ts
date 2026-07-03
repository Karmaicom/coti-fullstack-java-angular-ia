import { HttpClient } from '@angular/common/http';
import { Component, inject, signal } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-autenticar-usuario',
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './autenticar-usuario.html',
  styleUrl: './autenticar-usuario.css',
})
export class AutenticarUsuario {

  //declarar um objeto do tipo HttpClient
  //e inicializa-lo por injeção de dependência
  private http = inject(HttpClient);

  //Atributo (signal)
  mensagemErro = signal<string>('');

  formAutenticar = new FormGroup({
    email : new FormControl('', [Validators.required]),
    senha : new FormControl('', Validators.required)
  });

  //Função para fazer a requisição para a API
  //será executada quando o botão "submit" for clicado
  autenticar() {
    //Enviar uma requisição HTTP POST para a API
    this.http.post('http://localhost:8081/api/v1/usuario/autenticar', this.formAutenticar.value)
        .subscribe({
        next : (response) => { //Capturando se o retorno for sucesso da API
          //console.log('Sucesso!', response);
          //Salvar os dados do usuario autenticado na sessao do navegador
          sessionStorage.setItem('auth', JSON.stringify(response));

          //Redirecionar para o dashboard do sistema
          location.href = '/app/dashboard'
        },
        error : (e) => { //Capturando se o retorno for diferente de HTTP do grupo 200
          //console.log("Error: ", e.error);
          this.mensagemErro.set(e.error);
        }
      });
  }

}
