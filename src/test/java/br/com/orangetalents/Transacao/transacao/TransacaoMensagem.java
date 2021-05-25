package br.com.orangetalents.Transacao.transacao;

import br.com.orangetalents.Transacao.cartao.CartaoResponse;
import br.com.orangetalents.Transacao.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMensagem {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private CartaoResponse cartao;
    private EstabelecimentoResponse estabelecimento;

    public TransacaoMensagem(Transacao transacao) {
        this.id = transacao.getIdTransacao();
        this.valor = transacao.getValor();
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.cartao = new CartaoResponse(transacao.getCartao().getNumero(), transacao.getCartao().getEmail());
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento().getNome(),
                transacao.getEstabelecimento().getCidade(),
                transacao.getEstabelecimento().getEndereco());
    }

    @Deprecated
    public TransacaoMensagem() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public Transacao toModel() {
        return new Transacao(id, valor, efetivadaEm, cartao.toModel(), estabelecimento.toModel());
    }
}
