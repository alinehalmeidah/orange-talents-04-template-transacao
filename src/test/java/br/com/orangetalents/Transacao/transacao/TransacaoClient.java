package br.com.orangetalents.Transacao.transacao;

import br.com.orangetalents.Transacao.cartao.CartaoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "transacao", url = "${transacao.host}")
public interface TransacaoClient {

    @PostMapping
    void efetuarTransacao(@RequestBody CartaoRequest transacao);

    @DeleteMapping("/{id}")
    void encerrarTransacao(@PathVariable("id") String id);
}