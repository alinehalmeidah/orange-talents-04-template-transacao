package br.com.orangetalents.Transacao.transacao;

import br.com.orangetalents.Transacao.cartao.CartaoRequest;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoClient transacaoClient;

    @PostMapping
    public ResponseEntity<?> enviarTransacao(@RequestBody @Valid CartaoRequest request) {
        try {
            transacaoClient.efetuarTransacao(request);
            return ResponseEntity.ok("Transação iniciada");
        } catch (FeignException.FeignServerException | FeignException.FeignClientException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro");
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> parar(@PathVariable("id") String id){
        try{
            transacaoClient.encerrarTransacao(id);
            return ResponseEntity.ok("Transação Finalizada");
        }catch (FeignException.FeignServerException | FeignException.FeignClientException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro");
        }
    }
}
