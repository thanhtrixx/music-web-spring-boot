package tri.le.music.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by TriLe on 2016-04-21.
 */
@Entity
class HumanEntity(
        var name: String = "",

        var description: String = "",

        var url: String = "",

        var imageUrl: String = "",

        var type: HumanType = HumanType.Singer
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    enum class HumanType {
        Composer, Singer
    }
}