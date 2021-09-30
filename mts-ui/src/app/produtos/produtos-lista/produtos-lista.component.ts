import { Component, OnInit } from '@angular/core';
import { ProdutosService } from 'src/app/produtos.service';
import { Produto } from '../produto';
import { Router } from '@angular/router'


@Component({
  selector: 'app-produtos-lista',
  templateUrl: './produtos-lista.component.html',
  styleUrls: ['./produtos-lista.component.css']
})
export class ProdutosListaComponent implements OnInit {

  produtos: Produto[] = [];
  produtoSelecionado: Produto;
  mensagemSucesso: String;
  mensagemErro: String;

  constructor(
    private service: ProdutosService,
    private router: Router) { }

  ngOnInit(): void {
    this.service.getProdutos().subscribe(resposta => this.produtos = resposta);
  }

  // Método Cadastrar
  novoCadastro() {
    this.router.navigate(['/produtos-form'])
  }

  // Método faz chamada para novo cadastro
  preparaDelecao(produto: Produto) {
    this.produtoSelecionado = produto;
  }

  // Método deletar
  deletarProduto() {
    this.service
      .deletar(this.produtoSelecionado)
      .subscribe(response => {
        this.mensagemSucesso = 'Produto deletado com sucesso!'
        this.ngOnInit();
      },
        erro => this.mensagemErro = 'Ocorreu um erro ao deletar o produto.'
      )
  }
}
