enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

class Usuario(val nome: String) {
    private val formacoes = mutableListOf<Formacao>()
    fun matriculado(formacao: Formacao) {
        formacoes.add(formacao)
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        usuarios.forEach { usuario ->
            usuario.matriculado(this)
            inscritos.add(usuario)
        }
    }
}


fun main() {
    val conteudosLamp = listOf(
        ConteudoEducacional("MySql Básico - CRUD", 30, Nivel.BASICO),
        ConteudoEducacional("MySql Intermediário - Joins", 60, Nivel.INTERMEDIARIO),
        ConteudoEducacional("MySql Avançado - Instalando MySql no Linux", 90, Nivel.AVANÇADO),

        ConteudoEducacional("Linux - instalando o LAMP STACK", 30, Nivel.BASICO),
        ConteudoEducacional("Linux - configurando corretamente o LAMP", 60, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Linux - manutenção e administração do seu servidor", 90, Nivel.AVANÇADO),

        ConteudoEducacional("PHP - Quando usar o cifrão - $", 30, Nivel.BASICO),
        ConteudoEducacional("PHP - Symfony, Laravel, CodeIgniter e Cake", 60, Nivel.INTERMEDIARIO),
        ConteudoEducacional("PHP - Legacy: aprenda a manter sites antigos em PHP 5 ou menos", 90, Nivel.AVANÇADO),

        ConteudoEducacional("Apache - Instalando", 10, Nivel.BASICO),
        ConteudoEducacional("Apache - Configurando seu primeiro site (copie nosso .htaccess)", 15, Nivel.INTERMEDIARIO),
        ConteudoEducacional("Apache - Aprendendo a ler a documentação", 90087, Nivel.AVANÇADO),
    )

    val formacaoLampStack = Formacao("LAMP Stack", conteudosLamp)

    formacaoLampStack.matricular(Usuario("Martin V. Mensch"))
}