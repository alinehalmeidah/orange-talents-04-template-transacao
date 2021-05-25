package br.com.orangetalents.Transacao.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {
    private final Logger logger = LoggerFactory.getLogger(TransacaoListener.class);

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoResponse transacaoResponse) {
        logger.info("Transacao {}", transacaoResponse.toModel().toString());
        transacaoRepository.save(transacaoResponse.toModel());
    }
}
