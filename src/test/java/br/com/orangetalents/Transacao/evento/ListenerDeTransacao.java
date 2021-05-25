package br.com.orangetalents.Transacao.evento;

import br.com.orangetalents.Transacao.transacao.TransacaoMensagem;
import br.com.orangetalents.Transacao.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoMensagem eventoDeTransacao) {
        System.out.println("---------------------------------");
        System.out.println("Nova Trasação");
        transacaoRepository.save(eventoDeTransacao.toModel());
        System.out.println("Concluído");
    }
}
