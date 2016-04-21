package tri.le.music.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by TriLe on 2016-04-09.
 */
@Entity
data class ConfigEntity(
        val key: String = "",

        val value: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    constructor() : this("", "")
}