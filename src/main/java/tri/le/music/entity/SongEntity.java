package tri.le.music.entity;

import tri.le.music.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * Created by TriLe on 3/5/2016.
 */
@Entity
public class SongEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private ArtistEntity artist;

    @ManyToOne
    private AlbumEntity album;

    private String composer;

    private String genre;

    public SongEntity() {
    }

    public SongEntity(String name) {
        this.name = name;
    }

    public SongEntity(String name, AlbumEntity album) {
        this.name = name;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }

    public AlbumEntity getAlbum() {
        return album;
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
