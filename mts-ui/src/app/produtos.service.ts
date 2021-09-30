import { Injectable } from '@angular/core';
import { Produto } from './produtos/produto';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  constructor(private http: HttpClient) { }

  
  salvar(produto: Produto): Observable<Produto> {
    return this.http.post<Produto>('http://localhost:8080/api/produtos', produto);
  }

  atualizar(produto: Produto): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/api/produtos/${produto.id}`, produto);
  }


  getProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>('http://localhost:8080/api/produtos');
  }

  getProdutoById(id: number):Observable<Produto>{
    return this.http.get<any>(`http://localhost:8080/api/produtos/${id}`);
  }

  deletar(produto: Produto) : Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/produtos/${produto.id}`);
  }

}
