package jp.ac.uryukyu.ie.e175737;

/**
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 */

public class LivingThing {

    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     */
    public LivingThing(String name, int maximumHP, int attack) {
        setName(name);
        setHitPoint(attack);
        setAttack(attack);
        setDead(false);

        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead(){
        return  dead;
    }

    /**
     * 生死状態のsetterメソッド。
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * 名前のgetterメソッド。
     * @return ヒーローまたは敵の名前
     */
    public String getName(){
        return name;
    }

    /**
     * 名前のsetterメソッド。
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * HPのgetterメソッド。
     * @return ヒーローまたは敵のHP
     */
    public int getHitPoint(){
        return hitPoint;
    }

    /**
     * HPのsetterメソッド。
     */
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    /**
     * 攻撃力のsetterメソッド。
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }


    /**
     * 相手へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if( !dead ) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        setHitPoint(hitPoint);

        if( hitPoint < 0 ) {
            setDead(true);
            System.out.printf("%sは倒れた。\n", name);
        }
    }

}