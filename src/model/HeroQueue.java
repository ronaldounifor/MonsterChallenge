package model;

public class HeroQueue implements Cloneable {
    private Unit primeiro;
    private int quantidade;

    public HeroQueue() {
        primeiro = null;
        quantidade = 0;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    public Unit retornarElemento() {
        return primeiro;
    }

    public void enfileirar(Unit novoHeroi) {
        if(estaVazia())
            primeiro = novoHeroi;
        else {
            Unit ultimoHeroi = primeiro;
            for(int i = 1; i < quantidade; i++)
                ultimoHeroi = ultimoHeroi.getProximo();
            
            ultimoHeroi.setProximo(novoHeroi);
        }
        quantidade++;
    }

    public Unit desenfileirar() {
        if(estaVazia()) {
            return null;
        } else {
            Unit removido = primeiro;

            primeiro = primeiro.getProximo();
            removido.setProximo(null);

            quantidade--;
            return removido;
        }
    }

    public boolean takeDamage(int damage){
        boolean especialMorreu = false;
        primeiro.setHealth(primeiro.getHealth() - damage);

        if(primeiro.getHealth() <= 0) {
            if(primeiro.isSpecial())
                especialMorreu = true;

            desenfileirar();
        }
        return !especialMorreu;
    }

    public void applyBuff(int heroPosition, int buffStrength) {
        for (int i = 0; i < getQuantidade(); i++) {
            Unit heroiAtual = desenfileirar();

            if(i == heroPosition)
                heroiAtual.setAttack(heroiAtual.getAttack() + buffStrength);

            enfileirar(heroiAtual);
        }
    }

    @Override
    public HeroQueue clone() throws CloneNotSupportedException {
        HeroQueue clone = new HeroQueue();
        for (int i = 0; i < getQuantidade(); i++) {
            Unit heroiAtual = desenfileirar();
            clone.enfileirar(heroiAtual.clone());
            enfileirar(heroiAtual);
        }
        return clone;
    }

    

}