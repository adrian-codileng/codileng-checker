PGDMP                         x           codileng    12.4    12.4 (    5           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            6           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            7           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            8           1262    16393    codileng    DATABASE     �   CREATE DATABASE codileng WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE codileng;
                postgres    false            �            1259    16394    cat_categorias    TABLE     �   CREATE TABLE public.cat_categorias (
    id_categoria_prod integer NOT NULL,
    nom_categoria_prod character varying(100),
    desc_categoria_prod character varying(100)
);
 "   DROP TABLE public.cat_categorias;
       public         heap    postgres    false            �            1259    16397 $   CAT_CATEGORIAS_id_categoria_prod_seq    SEQUENCE     �   CREATE SEQUENCE public."CAT_CATEGORIAS_id_categoria_prod_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public."CAT_CATEGORIAS_id_categoria_prod_seq";
       public          postgres    false    202            9           0    0 $   CAT_CATEGORIAS_id_categoria_prod_seq    SEQUENCE OWNED BY     o   ALTER SEQUENCE public."CAT_CATEGORIAS_id_categoria_prod_seq" OWNED BY public.cat_categorias.id_categoria_prod;
          public          postgres    false    203            �            1259    16399    cat_proveedores    TABLE     '  CREATE TABLE public.cat_proveedores (
    nom_proveedor character varying(100),
    dir_proveedor character varying(1000),
    telefono_proveedor character varying(20),
    email_proveedor character varying(30),
    contacto_proveedor character varying(30),
    id_proveedor integer NOT NULL
);
 #   DROP TABLE public.cat_proveedores;
       public         heap    postgres    false            �            1259    16402     CAT_PROVEEDORES_id_proveedor_seq    SEQUENCE     �   CREATE SEQUENCE public."CAT_PROVEEDORES_id_proveedor_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public."CAT_PROVEEDORES_id_proveedor_seq";
       public          postgres    false    204            :           0    0     CAT_PROVEEDORES_id_proveedor_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public."CAT_PROVEEDORES_id_proveedor_seq" OWNED BY public.cat_proveedores.id_proveedor;
          public          postgres    false    205            �            1259    16404    detalle_venta    TABLE     �   CREATE TABLE public.detalle_venta (
    id_detalle_venta integer NOT NULL,
    id_venta integer NOT NULL,
    id_prod character varying(25) NOT NULL,
    cantidad_vendida numeric(8,2) NOT NULL
);
 !   DROP TABLE public.detalle_venta;
       public         heap    postgres    false            �            1259    16407 "   DETALLE_VENTA_id_detalle_venta_seq    SEQUENCE     �   CREATE SEQUENCE public."DETALLE_VENTA_id_detalle_venta_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public."DETALLE_VENTA_id_detalle_venta_seq";
       public          postgres    false    206            ;           0    0 "   DETALLE_VENTA_id_detalle_venta_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public."DETALLE_VENTA_id_detalle_venta_seq" OWNED BY public.detalle_venta.id_detalle_venta;
          public          postgres    false    207            �            1259    16409    ventas    TABLE     m   CREATE TABLE public.ventas (
    id_venta integer NOT NULL,
    monto_venta numeric,
    fecha_venta date
);
    DROP TABLE public.ventas;
       public         heap    postgres    false            �            1259    16415    VENTAS_id_venta_seq    SEQUENCE     �   CREATE SEQUENCE public."VENTAS_id_venta_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public."VENTAS_id_venta_seq";
       public          postgres    false    208            <           0    0    VENTAS_id_venta_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public."VENTAS_id_venta_seq" OWNED BY public.ventas.id_venta;
          public          postgres    false    209            �            1259    16417    cat_productos    TABLE     �  CREATE TABLE public.cat_productos (
    desc_prod character varying(1000),
    id_prod character varying(25) NOT NULL,
    nombre_prod character varying(100) NOT NULL,
    stock_prod numeric(8,2),
    foto_prod bytea,
    unidad_prod character varying(50),
    precio_compra_prod numeric(8,2),
    precio_venta_prod numeric(8,2),
    existencias_prod numeric(6,2),
    id_categoria_prod integer NOT NULL,
    id_proveedor integer NOT NULL
);
 !   DROP TABLE public.cat_productos;
       public         heap    postgres    false            �
           2604    16423     cat_categorias id_categoria_prod    DEFAULT     �   ALTER TABLE ONLY public.cat_categorias ALTER COLUMN id_categoria_prod SET DEFAULT nextval('public."CAT_CATEGORIAS_id_categoria_prod_seq"'::regclass);
 O   ALTER TABLE public.cat_categorias ALTER COLUMN id_categoria_prod DROP DEFAULT;
       public          postgres    false    203    202            �
           2604    16424    cat_proveedores id_proveedor    DEFAULT     �   ALTER TABLE ONLY public.cat_proveedores ALTER COLUMN id_proveedor SET DEFAULT nextval('public."CAT_PROVEEDORES_id_proveedor_seq"'::regclass);
 K   ALTER TABLE public.cat_proveedores ALTER COLUMN id_proveedor DROP DEFAULT;
       public          postgres    false    205    204            �
           2604    16425    detalle_venta id_detalle_venta    DEFAULT     �   ALTER TABLE ONLY public.detalle_venta ALTER COLUMN id_detalle_venta SET DEFAULT nextval('public."DETALLE_VENTA_id_detalle_venta_seq"'::regclass);
 M   ALTER TABLE public.detalle_venta ALTER COLUMN id_detalle_venta DROP DEFAULT;
       public          postgres    false    207    206            �
           2604    16426    ventas id_venta    DEFAULT     t   ALTER TABLE ONLY public.ventas ALTER COLUMN id_venta SET DEFAULT nextval('public."VENTAS_id_venta_seq"'::regclass);
 >   ALTER TABLE public.ventas ALTER COLUMN id_venta DROP DEFAULT;
       public          postgres    false    209    208            *          0    16394    cat_categorias 
   TABLE DATA           d   COPY public.cat_categorias (id_categoria_prod, nom_categoria_prod, desc_categoria_prod) FROM stdin;
    public          postgres    false    202   z2       2          0    16417    cat_productos 
   TABLE DATA           �   COPY public.cat_productos (desc_prod, id_prod, nombre_prod, stock_prod, foto_prod, unidad_prod, precio_compra_prod, precio_venta_prod, existencias_prod, id_categoria_prod, id_proveedor) FROM stdin;
    public          postgres    false    210   �2       ,          0    16399    cat_proveedores 
   TABLE DATA           �   COPY public.cat_proveedores (nom_proveedor, dir_proveedor, telefono_proveedor, email_proveedor, contacto_proveedor, id_proveedor) FROM stdin;
    public          postgres    false    204   ��       .          0    16404    detalle_venta 
   TABLE DATA           ^   COPY public.detalle_venta (id_detalle_venta, id_venta, id_prod, cantidad_vendida) FROM stdin;
    public          postgres    false    206   9�       0          0    16409    ventas 
   TABLE DATA           D   COPY public.ventas (id_venta, monto_venta, fecha_venta) FROM stdin;
    public          postgres    false    208   l�       =           0    0 $   CAT_CATEGORIAS_id_categoria_prod_seq    SEQUENCE SET     T   SELECT pg_catalog.setval('public."CAT_CATEGORIAS_id_categoria_prod_seq"', 5, true);
          public          postgres    false    203            >           0    0     CAT_PROVEEDORES_id_proveedor_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public."CAT_PROVEEDORES_id_proveedor_seq"', 1, true);
          public          postgres    false    205            ?           0    0 "   DETALLE_VENTA_id_detalle_venta_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public."DETALLE_VENTA_id_detalle_venta_seq"', 3, true);
          public          postgres    false    207            @           0    0    VENTAS_id_venta_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public."VENTAS_id_venta_seq"', 3, true);
          public          postgres    false    209            �
           2606    16428 "   cat_categorias CAT_CATEGORIAS_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.cat_categorias
    ADD CONSTRAINT "CAT_CATEGORIAS_pkey" PRIMARY KEY (id_categoria_prod);
 N   ALTER TABLE ONLY public.cat_categorias DROP CONSTRAINT "CAT_CATEGORIAS_pkey";
       public            postgres    false    202            �
           2606    16430     cat_productos CAT_PRODUCTOS_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.cat_productos
    ADD CONSTRAINT "CAT_PRODUCTOS_pkey" PRIMARY KEY (id_prod);
 L   ALTER TABLE ONLY public.cat_productos DROP CONSTRAINT "CAT_PRODUCTOS_pkey";
       public            postgres    false    210            �
           2606    16432 $   cat_proveedores CAT_PROVEEDORES_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.cat_proveedores
    ADD CONSTRAINT "CAT_PROVEEDORES_pkey" PRIMARY KEY (id_proveedor);
 P   ALTER TABLE ONLY public.cat_proveedores DROP CONSTRAINT "CAT_PROVEEDORES_pkey";
       public            postgres    false    204            �
           2606    16434     detalle_venta DETALLE_VENTA_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT "DETALLE_VENTA_pkey" PRIMARY KEY (id_detalle_venta);
 L   ALTER TABLE ONLY public.detalle_venta DROP CONSTRAINT "DETALLE_VENTA_pkey";
       public            postgres    false    206            �
           2606    16436    ventas VENTAS_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.ventas
    ADD CONSTRAINT "VENTAS_pkey" PRIMARY KEY (id_venta);
 >   ALTER TABLE ONLY public.ventas DROP CONSTRAINT "VENTAS_pkey";
       public            postgres    false    208            �
           2606    16460 &   cat_categorias nombre_categoria_unique 
   CONSTRAINT     o   ALTER TABLE ONLY public.cat_categorias
    ADD CONSTRAINT nombre_categoria_unique UNIQUE (nom_categoria_prod);
 P   ALTER TABLE ONLY public.cat_categorias DROP CONSTRAINT nombre_categoria_unique;
       public            postgres    false    202            �
           2606    16439 "   cat_productos id_categoria_prod_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.cat_productos
    ADD CONSTRAINT id_categoria_prod_fk FOREIGN KEY (id_categoria_prod) REFERENCES public.cat_categorias(id_categoria_prod);
 L   ALTER TABLE ONLY public.cat_productos DROP CONSTRAINT id_categoria_prod_fk;
       public          postgres    false    2717    202    210            �
           2606    16444    detalle_venta id_prod_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT id_prod_fk FOREIGN KEY (id_prod) REFERENCES public.cat_productos(id_prod);
 B   ALTER TABLE ONLY public.detalle_venta DROP CONSTRAINT id_prod_fk;
       public          postgres    false    2727    210    206            �
           2606    16449    cat_productos id_proveedor_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.cat_productos
    ADD CONSTRAINT id_proveedor_fk FOREIGN KEY (id_proveedor) REFERENCES public.cat_proveedores(id_proveedor) NOT VALID;
 G   ALTER TABLE ONLY public.cat_productos DROP CONSTRAINT id_proveedor_fk;
       public          postgres    false    2721    210    204            �
           2606    16454    detalle_venta id_venta_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT id_venta_fk FOREIGN KEY (id_venta) REFERENCES public.ventas(id_venta);
 C   ALTER TABLE ONLY public.detalle_venta DROP CONSTRAINT id_venta_fk;
       public          postgres    false    2725    208    206            *   ;   x�3�t�/*JT�-Rp*MUή�
$��)�&�*$�$�%'*��$�$�$r��qqq W�      2      x��W�eKve�]����}��}��E!he,���lBu�c���	P�2^�����}�9����W���w���?�������_��ؿ��r��������K_�?�����r_�������~��b������������_����������߭������������Z����������E�/����������o�����6�+������w���������z��~>�/��E�����������?����<��?���������}RO%}��?�繿�����<)�e*�}�_��{����|N�x�y6���C	5��{�����o����o{W����=�w�71�)�7�8�J���%>�h�w���'�XI��:���g-�V\��'|q�?��9�e{;�s���ݯ7��诼*��k'__���������wwۯ����;�o|��}/;������_������W���;��w����7�ӏ?��ӏ?��ӏ?���Ϗ�wn�~Y%~�����|�v�v������G�1��_⬉_b���]�\��o����R���YߵW��̿��Kwa5���2��\YL��O�3�
������X��}%�Os�+��������g�����ֿ6��JX��aĞ�)唱�q�r�yk����g{&��ݛ/�Z�~y��_V��{rae�U�o�9�IlB
��f����|��ƛ����@�w�ʶ�1@\c��W�k%`h������=c��]� >���lh���CȬ�M#���w�'��i��w`�xvL�y�.�5Κ�{"��{���9���9 b65|,k�v��RK5���l�l���K�Y��v	����m�y��ï�����ϫܖ����401O?��A�R��e�g���1Z�u��J�[����R�8��7sG'���aU5�󻇜YYIf{��D�=#����������fmp��>��|pz�w&�|p�)ԖYGWƻ޹>�4��%%,��q�-����x��}s�9}q�I������,���w��s��7��䧷���Ȉ�~<+>���<jh�O�Js�o����~��7�ҟ�Rog��>���6k"J_9=�r�({�7OV�Xa :B�)\���0�,�y_~{��Y=��IŰ�}�Ѝ{2�`H�]6���=�o�vJe���Ud����q���k��B��>�Z��=�7o~�9�kѾVY���q���apcY��q~T��O���Ɠ�����K���ٵ�V�+�;��9��!��_S|�(�2����w��>��)��$�b� ϯ���շ+~,|�jO�;���;~��'�Ɏcۿ��L4oqll���9�~$�W~>������ʹ����6�/��b�_%!�Tl+��P������� �U�Nr�>Y���-{��竤	1�Է��9��7r<���O�K�	w�Cᯓ����;��hT�$ާ�'|�Ng�5���3���+���-�T��9�ɲB�}W�����sv��������~�h��;X�5�XXT��b=I������NH�x�������L��j��;S7Z�������"�[08<NӍ	�Ϝߚ+���&u�K���yp:g:�qp�V��rc#F�ǆD����z�����#�3��忹����`�x@�c�tf,�Mc������O�~D	���R��1�5c[V묘6~���g���)X�������������U�tp���_Y�~x(�0��ޠ��M����p��\?�ͧa;����S������뵿s�O��H^�屽��	M��Y]���P��J��d�b�x�>�/���a�&>sˡ������ղ����
J��'�:\ϻZZ��u�'����������*n~��`od3���[h�4X`fM<?�d�߭�
��'���թ\���B�b���0�I.R��������­��GA���=ؑ�;�"Zޭ(Eɟ7ԗ���i��Z �
�7;�7egN�=�WČ�(�t���k��0=姯�΂GT��9�% v���<]{��-_؀��e����⟼W�X�]g��9���N@�>}w�������B������Y�S�6hZ6';�8a���&�y�� ��_u$���g�����0��yj܂0��Yd��36���f�_!=n�ȿ��;����Ɗ]��~]�ʨ7��Qh1K��{䘜���X�UD�ȿ�ky�N-��#�^_��7<\�}�s�X6���ڹ�Y�{h*<G�λ���-j�R����g3������-?��=�u�_{��j�lb��c��J��e?�7!�}��|~���{��r��'�8U����S�|�f��������{M[>XB�4(��`�$�Ɖ>" �[���Zx�C�0el�G��}p1����C�P	� �y\`mbI�l��~{O�2���/���^���abñ8��:g�?�X��A��Nx2�rp�R��Q��*���'��"�q�^�xB����,^̮���!/��۟S�?2$�K���<聉 ����#FpB+�\��.l.���oE2�/	׿y�ui_��T#;v��I���I��p�f��T��)	1����D)z�@�t�+_�Ļh/��鐚�j{<Sv��i��6�f���ex~|#���ħ�z�j�B�טM�«K�e6�8y�������G��a��&
w���i��.�$>�3���ى�� 1k}�@ ��o��Y市z���a������65B`w@�U��T����!���*��A��u�ށB�1�}QL�[��!�:%�s�kI��wa�Z�)��5�!׻�w{�(��x;���&�4.���f�H�Į��~,��
WR�Q����iXN�S�m���s����8�*�+B��1l�a����щ������:���A6�FR^W�cwK�`6���ĳ��ɬx��>����7V�Y���|��]@P����^Q��RpN?�/6k��|Z��B?�l�"9���kc�A�G���/D�o�@�kVZ�4��J�K���%K��+N�3$�~~�7��P%�w���5��+vhb3O)X��~�
:�_~�k.��ׂ�k��O��]���_}T�.�7���ӈ��j�v+���Y��?v_k0��l�|r��𲠣Ebte��M����J�b�-��@�Z�|[���ϮW�·�u����?���n�d٠G0�!��`�_��a�Bak ��|%��??�[ qmغ�׬��y[�:;�C��#�ʰ ��j#f�8��+�H<G�OYr�i���Y��:�I�؄6����,ɭ1�Qo�W|x�֤!Ʈ�3���)�Գ(YH7�e�<��=~I6UK���UB��:@��\�H��G���EFd�W�� b�����5ri���z���|*���,�h8�d]��-�`Kr�]C���r��7���s�9�ҡJ%�;�a�*�Ll�~��Fl;o g���e��đ�>Q���G�h0o�'2�!�������@�[�7��l���Y��XH̝��/�@�o����Ëԧ@Ë{��C6�>Y��X��mt�"(�vt���i�H���X�$w�KEYLg#2�|���ώ�:2�/­�f�;wUH�������NK����aC[��eml��$�Q�,��������6)�!�FCFuS,��ױ5�׸�u���#���@<���D�(1���1���T��!�W�g�UR������t�K�>m��X@��:�i���ܠ0@g���"17����xa+ ���ͮ�"kNs����u�8��`l2-6@K2.	
��<�"n/���'���D�a����MR�g���L��aё�)�؇�,mj`3������g�O��xs	&�,����G���*i���ڵ�	�[�Ux�T��X�� ���b��i�^pV����/����g��8Z��ي�Z��\+�g��4����1/����d�0^'�5߃֍
����&�V|7P'��)c�J����*+@�r	ԫ���wBi��[�x��p|'h�s�s    V�}5`��x<E�IД|z��;�b�iL&T?b`#"�onA7�9{И2�b��z˥.h���� �ݭn(w�Ф놨�bȱ�����s�`�)n�Y��`,!i��9��'(\3�����<P��ht�]4����=|熈�X����*z}�c�N�ײ�Q�_PE#�7��<?���p��M�'Y��G�+$�Sz9����u4ài6F6��n���|�n���Al���` P\a.�ӿX�aP6r���RT˳@н��ư��#��������sN?d�/���=��!�&J~��*�އ��p����8�OyN8��<d�jt<��gM��������o2:�X��1������S<��a��W��Q�.���`~���O���r���JD?�J��Ӷb���G�Ŧa���Ρ~�d[}
� �Sn8+��|�o��v���t9�r�}��L�s���~	��'#��_OtE=C;��,.~ŬU��������<�7px���/e�VB���C�5 $��Q��F�!V��|��Ӿy5��A��O������hC >�CzP��C��Ó*���
��
�o>�A��`Z� ��Z�C~�i���/��p�� �؛�vB@���}+���_���ʇ�<�t��
�T��^.�C��t����L���_��C4g�@DE����E��G���0Ɉ}��|G,���"ƌ�G�[���V}�lla�s<�D5&��1{�/�������qz �sn��2䃣����5�?���'<��"��E�N����9@��~�W�U�4��#�|�O���8�M{�ĕ��0�ݡ	=��+��j�|,��Ah�����Bv�&#1`�}����s�﯏��{\���X(��_p'8:wy�ל繰e?�;!"�\���ӚUW����i�r&`��&b7�O��?y���X�!���K�uA<O4����K��U�T,`���7֔��cG?�^s��)&��%��n!���hX��������M�`AL�"��j���¦xO�(�m���UMuuѳo�!���R܄�/|��q�2�O�&~4L��9��}[��r7 �?R�%���y��L�{Ռ�J��jtk�~t����Б7��sSA ���������ry:����h ���\�z��x<@ �~/]ә �o�/��`������b����??�+�����~��?,�xҏ[����hKk���d������>��7�����Q~V�ϻ���}�Y%�:�[�e��/���Y�8������3��M?UB�`ȯR�_a����~m�o��y�����{�i����{*����O?�������NŬ?M鄟�~�����%��_�����?=O��\�7�[���נ:t ��T��L�w�&4����޳�Ęr�n`�1����,.0�4�'HF5c�m&��=�~u\mSi����� ��<c�ן��������b�������Y�i�����5�Al~�[���.��w����Mo�wh;�8���}�!?�~V�����>���h���Vk#�7�imQ[��V+VLn��Kmߘ�K�F��?��Z�������a��� ���#������R���d�����ܘ'����{?�=��_Y���gO+�{���b��,h���;6�?�3S�qu},�
Y�	��p�y3:]���꛵��3|�S�Пu6^������:�p���O��z9!��[���z������Eo:|��j6���$�+���lu�Y�d?&Kj���X��4+zb���K 7 �>���U���c ��0Q�PC/�;�t���͌4t:����dp��!zm�i�1 ưUKJ��8î � ^�̈́K?΅�>i���ӿ�mV��8�G�lt�yD���S����S;�m)�;�|�]��`G�rX��.�D�7F8��Y��i���[��\󞽟�x�w�$��n���E�-13W�!&�3A>�QOP��!)?˒���R}6������3�&&{�	�����] d���@ԭ,��T��d�d?�}b��x.d h���C�j��ۨ	TQ�16�Α K�㝞�xW��a^�t���������~���\��8H��2��mx^�f#�q|D|�LQ\�x>��̦1Q�G�| ��>d�B��t�1SKUQ�VL��wl伌��A��7 �l'�k�/O`Q"p����a<��O�����w����K�[}�b���bu��5�����bk��g����|��a3*�NY�J]���-ے��α�FC?s9(@Y�p�2��؍�Y��.��]���-	eu�֬��2Wx����*Gb���=V�B�U�S�� ���:�(S׭�o�iR�a�8Z�:�Me?Z���P�[��[4l)O8j��� ����I�k��/1P|����\�}Q���ڭ�L�'�V��}�پc}�;LO�������ڽ>&�_Ӊ7��ē���ү��m��. �fȰf5a�o:��V����G�ߏ�ږP�3��)���C����7��3l���,�Tw�&vmpO���)g޺��[�A�Ǡk�ϲW�P�y>��A!6|�g]T�����}��K�Э��fO-���6��}�P�8'�y�d���.���a���r�`"g��Q�ԛ9*ęE�*3f�`��n�t��`, (#�Z�'2cF��byD�Bmi��5<'�#C!��X�x�zٞ����^��rn/b{�d�֟�~�'fۋ-F�˗�	\E�q�-���k}��̾X��S�{�](hqn����}�m���@���n�q�o�r@�P��v��4���O�fk߷��ꋽx^��5�/[�P:����T�U;f q�xW�l�@'�;�
J� S�G|��4Z�׊5�0����n��_�Ǌ�D�u��9�N	?�T��<�<˶0;|�,��*�!y��`S �菰B��� �02�Ł*�H�:�ڰL�[|�4*]1��6+��0��.{�^ݜ%���� ��$�`ՑZ���ca�g�$���I�U�@��,mh���8�7���R��0ʡV�����m9�Bn�n�nż<X���n<���'�Uu[��^m����D˴���X/T�+Y�?��lH���F ����_ �έ�1��`����&��ӊ��w���Y�	�ǰ�U�,t����G�}nϰ�R��v�����`�0��$�vr H����<- zq&��WF��\��bZ���7�N�p3�	�#j�	���;6�$4��}|o�f���|rQ���88	d�A��d�J�.+���5�q��Ec_lY�$��Z�m��E(~�/V?*�s�Zl���dީ]8,OL�L�J�c�9о�5�ˢ ��px��i(@�a�,j�������f17f�y��X���S��m�:|*��B�m��m[�/Pp�5��8|,+���D�{�ɿ-��|؝�e`(�s�xNU~���Z���i�{!���W���|4�`��2�+s)e-��+���\<<_����50��ڛŖ�\��w��N��@��N�T�� ��弄�bV�PJV�b���7�<l�^��&d ��{��Z�ecy��H���h,^��u>��w�Ҫ�ݭ޾��!Y�e��4<bX��2L����  �)�����I?��y��6��Q��(az�e�tm�W<+�;,��0j��,�Q*���m;����XQ��f�
���^�>{߀w� ��E������F�ơ�����O��Wk�4Q|;[�Y�.'Z��9�xOL8������6fm�1�Xmg�9�x;���%_�'6#iq;(����P��'6"��~j�q���T�4=r��bپ�����YkjYv�7�#��,�"����*h�P>�'�Y�����?c��2� �Ĭi�4`uq��p�(N|[Ae��{���M���HU]Fox��=L\j��Acx9چ���n��&���m�r,�U��n^�͋&��    !~h���[m�3j��m�3k��X"<3����+4&.k
py�l�Q#%k`7�� �.�]B2H���`:�f5��8��aӱ�X�RTP����f�j�7lIC��-�����UlZ�v�<;��\��!��r��tp������f����d#�����S��/�m�1��Z뜜�Z��WS)�!���~�8�B �@;���a�߳�%��#��Xl� E �����,��-{Ӧ����Il�V޽L	0B*q���N`����.و����˟ � X�����M=��R'�i�_1~��׺Ŭ�;m9HW`9P^�F�loٽ	4�Uy��0Y3�IeE�7}��������M�l����(.����Э�*M��8�w��,��ǂ�qd~��	ߟ�3����xFD�y{:�m�V�6D2�tګ�������f_tC6�
c����L�-1��0�d//K�QI���Ν2$��O_��/���%���[{4�=0��H�|ˑ��:L!��~�N�

���ۻ��-�C��e~��_?��n�ª�a��x�U�\l%�]b�t_|O}e���??�6N}�a��3<	[�@�6S4���&c?A��U[Հ�e #l��= ��zX'k�{��'�c�J\E��C@�90�����W��玴aOIg�wȕ�w<|���-V�s�Pq㖷�l݆r�O�%�ct���F����|7$�§M��#�m ��^9	���y�?��X̯[�Hd�U�,��Z2��)xgk�,d��CWЊn���o�����ky���YO $���ap<S4>�H4?=��\,����tܖ5�P��A�`y<d������꘱�XΝ`9��g�;$�TD��;e�������l�� YLֵ��gP[�7Y�*��]p�?<==�N��;�3���!�Q������ܷ�����S�Ue��	���ڱ��&�����wk��5���p�Q᥎�{��!�R@��}��H��i���W3 �d�� �%G�$<@�h�E��d��4���Ξ�\�tP�4J�v����g�J�!8N�؏��o�U�=O���V�#q`��S�]�n\�a�I� ��гԺB��f�`�Ŋ��7��I@�T�����p߈/$�6sh:����C�K��X�*��s��~H��]�j�f�2��嫆��h]W=ht��
��s#�^������~�kp�;)�*+0o���O0@;���>����Ů'��1�:@�ŕ�M�?5�W]xJ(���]�����뷨|�m�;��|�w�/�ܡNPV���_�K��k+�p,��:@N�,��68/D pg���n�d\B������;��`b�.-��l�-����.��r�@��^�lc������nl,�{A��!�tUlY��u�S$^hc��e��L�,*"���x�_��i�������A|���3F%��`�Tσ|S����u��5@�r�Q��Ylԟ�:��H�+����	�x'�<��]���hÃw�<�}����<�x�w=��W�7cZl'�y �6s`�0��Y|��FvQ5q�+t���а@v�UG�#b��tY��������a��Uщ'�Y� $$��7@޲�q� ��0g��V	�X�GU�{���	5/�������J$�� �*����f������(��xM4xTpHY�k��G��;�i��&'��s>�90�u���(�c�4���d%�3"���tQ*����<͛���G1�5���b.K
Vs{��U��5��D�$=���~j4��6���I���͒bHn]9�ec8`i�jum�q%�  [D�[�;��a�� �2^\��i�,�9�u]4~��Sہ++R
��nb3�X�V��(IKϙ�\�����
f��9��F5Lj����$qIu0��%f 8��<ɼ�����|KT|[�F��O����l���hG�8����jf��;���l&QpR�k�<�Sg�஛� ��9���-�h�<a}������-.F���
t���N�7L� }< ]�Ϧs���3��s�V���MU�c>�����[+p���Z��;�ITn�ٷ �HPU`Ƒ�]�y�I���_��]��Y���}����q$��TX����>�� �l;h�f�-���}=\�=��Hs�v��N�<vle����c�/��1��\X������p:;-.�u)κ�t��� #����!k+gh���I�ς`��֧�l2Vz_r�SՒ%��,/�o aA*�I�M�]�������P�:�7�Yq����f��v�,����9�������7=^�3l��y���9���ڢX����kY�Lؓ�Zh����Q��+�l�p����l|���#��BF�P%q}'[�6,c�iW�:�:���('%�F���8�Ӈ���*�w?c]�> �w�ɐ�S�h�V'^���Mٍ���.[��G�7�>'�g~�5j�&����cr�(?��1t0��e�_A2{�M�7hr�: B�`��L4�e����V���j��3
L9�����o�H�u# ��Y8P1ܼ����q��5~h&t��j�r�]Ѩ	ޏ��2A6D�,8H�����w�o�fd&������m��	�Se&Ԝ5,��u/�T-/B��BpՀ��>��b0QI@��%�ml\ ���|�+]�<�H��p��_�n/  �ѯE"�q�w��i�{�P���J+]����*f��@4[1��:p���>����!�����l��ڵDlx��[�e0�#��܅%x%�}��0������v`���L���e �-V��(���	+@�̤�a�?�9�'kkʾ^��A��	�d W�h��f�	֘`sN�C��i?)E6�ȹmx�5��ϸh��-��������� ��hݾ|�czi�Iw~��/�ꄇ�fTp�۫�ܶ���#�mƛw��x���e�}b�X�iU�	&���zLX��F�PG���l�6��%�J)�sG8���yVf���
:3��:d|��[�����u�_���P|j�!m&� ����xF62ۀW���8�"�64��)�	�ۉ��ݺ+���yH� ��.c�(܁�F2.������48�b�k�Nm��f�m����w� ���z�m��I1e��;�Q(�_P�Ϥ����p��9����EW��|���w�,:,QL���	:�C���[A�0�lwG�0���e��
|�pf��P3߁t��
�anm�P���Bv��9�������'% ���|&�pc(6�J<��)��_�up��-�����:���r��t�g�aHƳXX�-T8N2s�D�w����	Ƽ�F>���̮m�����z8��ɨ[��Zi�i[��<C4��ĳw��[�k�9����t��\pILbѢ�)����b����ٓ��8�f��b���:�N+���F��9�;	�q�� 4M�ZK>��;c;��E��;����,&c�Ӝ������1�;E��ø%$�hѵ�Bغ04��hI���� �|��sޘ
���B|��!DgY�e���0�s��b;� #�3������x\��/(��qv8�?I"P�zpH�X&�ഴ��jG܀g�ʬ�)g�8�
&���n�F1oN��b�pXv{f5�M���Mmlk�����	B���G0��2���Ć4Gĩ㯃p�����S��*Jo!1�([o(� �Fd٪�=l>M�f ��g��ߒzz�����,0��#��|7�hxh(�[<�3;@$S䬓M��X��jF\��G6]*����g<�Ld�yJ��p�� ~1�<��}UT�'5�g��	B	��,����;QT��۞��\�o����X��� ��`y�9-����H��-VBJ������м {�fW��r��a9Yb$�a@��9�+�G~����PNp�M>��p�0r+zGe\Z��a@0@k��ts��    W3;�jce9��/��p�	C�s9��bU�Sv��DG��p�Fn��l�*z)'�8�v��d:qHf%�_0�ԋ�Y���m��:"�?oe��C�9��Q@���{?�R���q�sf#���:����ʓ��;�	�� q�)G���{��|x]wLN,8?��Z�Q�%�;dp 7���g�,�R�n���(7�e��ٍ`;l4;2]=h{A(o�������d�I���:���z�������q#���n�!����`<�n��<3v��C{'x�`Dlg��S�ڢ[Qz�ԁ��N�syNdJ�!�0�X>[��{W۔��T �>��)�)��-H��w|�Ѽ}��FK���b~5���]�t���q:*���Ո $���l������C�18�G�<�;��s�|bQHɈG#8��,vҡ'�\��j"o݊��7缍(�ƸI�voZ7v��L�!lCjQ�,�;���mN����_@�tx��#8=�.��.�0<L(k��[0�O��G����D�r�d}��r'�
C����,X'���x/w�%�4��v|��d�Ǌ^C���x�X��8�0�.���DFe�l+���IP87]�ڼ�s#�t���1���V6[z��w$9,�p��˒>�n&�A eߔ"��\f(�������o�;�
Y9H��-�E�p�6]<�:>	�EJ�s���8&����yL�� �J�;uӥ��>'Y �ǂ�|�ڄ�����%.a�qT�Y,���
mu\��\	-�q�{w�i�י�γB81h�ʛ xL�2׿aѷ��!8�48�v;8�Xm���N�َ��2t��&���bM2�AП���$,S��N���N)~<^�y��}��ry<��F�Uu��J`��<ÉSϰ��f�:o�T������;��gn1�n�PF��V��Fw�{W��q}n9m�t9�VM���i&l�}cRӡ��/.8VV�;e��ð��p�Ow�����S:^\�f)8t��8G�L��mX�T�$��3K�C.�;]t0�h=fQ8�.	,���d���a�Z��⢭Cb����!�n��EShƛ]��K,�����G�������?��B�2ǳٝsQ�`��Xг�͉���%��Λ�(0em�m�� 9ɜ4�B�p������J�kF�����[|�^c��	��l8�7����8	���0#���n����ƅ�ۮ?N��͒P�A �c��i�\x�;��4ĶJL6��"E�`��i������������a8a���;k:� �����c��ݴ}��-e��nY��8(j2�]�u�V85ܧ'լ�ú[3�лxrHO��Hp��r��(���c���HR��~��C�?�jN�Q�zc���p��QZDkfψ��+��(��F�� �0V?�ըi%���x^�кCE��m~�#�V5gϦ����BlY�g���}H'\�q�ޅ�P;��zbN �,.�|�pg��<��}z�j:��Y�8�;�7gC�'X�~�v��=1��]��0k�,���v%kP�*��mv��{���x���vx_�F��^�y歷L�U^�i,"8��l$5�HAPLY��2��QDi�.�8AQ�����;Վ,N�.VC,Y"Y �,`\��Gk}:[I�����loD��{3�k���>���'e�p�ź4g�`�����/ŉ��Ι��m�1F Z<�Y�@ɟ� ӠO�r��:4�n0��;�*�	�ע�m	��A��E�M>�5�!�����?�c�̕E%���ݚ:��,�;��*x~�b�QU�e� ��Y�@�����Ղŗ�k`1�4�v� �^�e����O5�6ћ�E�v�-��5�f���v��s�,��<9	�ހ���Msփ,��փ�s6��w�<�g�(r��]��χ��9>�͎H9h[U��;��[��cgd�J��#F�hF��-2���b��S�8
q��	�F�7V���'�LhW�Ƅ)a#���k���ϻ��f��/��|�N�t"
�u����gf����X�cw�wsu� `�NY�G-'�n�"��ɶ�6�1��rT��Ѳ&;�l���A�םU�7�+�Ŕ���?d���F�$-O�zM�;�d��>̪m��cy�Ab�jk�S��;�e�����yQ���elF��BDKނi�ό�b�D�[+��3��z[�h�3�z6d���3�M�hH-V�I�� ����pS?�1��K�� ����.D̪�ǔh�������;w
�`3`q2�GbT͍4�e���#�V�',z�w��F��k�I�ƴ�`;e���R/��&֭�3�{���X+�>yo7�~�Wjˈ"~����B�8�ό̻�1C�Xm�X!�t���.}3�M�˃�9<˜K�O�2��°��3j�C{;�}��K:۶��)��l��D��{;�מk�{�6a.>�xG����[��y��o��4�[������o=V�x���>I�W�,Cq��z!���Y?�o�	o����u�B� �d�Y��ۛ/�n����Uv�-�q�IR�b:=�6���	a�%��>�OB��մ�����3��z{[S]�߽Y"�3xH��p�$��G�l����1��DV���B�c�˳�P���E~���q&��(W(,�*��t_b!5VL�*�#_�5����O#���}��>�^;���
5ٶ��u'��4��E��>�NN��w&j���K��F�Ģ�[�d�i�֋�h�2#�����X�i=�����ۑ�߶�?7d�/�8�[���N
32�rr��dO���-���GsŰ�z�+��o��s{Ep�Ym[s"�gk��{iT�� �}��`�FH�᜜s0��'�qx��RK�����I���)�� ��ّ���UͲUe�$P����o��(��[��C�m|ᛓ�.�E��'�����~����HO���u:�E���݆����B���bǼ�}�s\�e
'�˞!�`;����|v7��'"�v���o�3N�3,?�+ܼ�u�e�=M��R�g[?f�iT^��|%H=�v)X����n��Db��̓�鲱��Xw��➷�
����ъ0[<'��|J���l������S\�ކ3� ^�7��	#^�}dh읯�3 � L[~3(���ck�6�j�.�%�Π����#�k��̜�1�R��w��_9�Iq:>
���N��"�
qp@�-��ad�I�.~ɋo{�#�ϕ/�������qg'���O�	�7KmB53����_� �sG��o�2.gmx�˭LL�f���d١�� ����0q�)kӷE�_�sLA��=��x/A6\S�o�ф)ަ�"˖���{�s����!��n�'����%lT��͵�6���a��t�݂&�ծ銯���l����
|�UQ{E�|�i��8C|�t�"�O.��������y���~X���w"r����v(�	[o!�w�}'[�l�P��L?���e�6a�l��7ߺ-�IG���2K� �Ǖ9pATz�
�KA,�F��"��?7#8�k��;l����*��(R�h/ǡ�F�q�Ri�<������˂%�AɵQݲ�/7"g������Nsy�a���(k����#�l�����s�D�e�Fv�f���y"rXK��//��	�e�j���h&й����\B1�0��aF��u�g�!7���O�=ë:��k��������?�\��_��{Z�7�$���V��,�m3Ǘ_��G�7nm��[l۾���e�<?�5��r�m4/}��С6#Y�Ye:`ӒA�wD�Q1����tѸ���[�cp���v��R��i��*n��r��H���1�QΔz?�rATHT���ڱ,�����/d4��/��P�S}n�����糲��F+���۶�c���V���sZ���\Ҟ�� lb9������~h&.3�:�I��/����!f�k�G��s�=���i�����j�����g����9Z|�X���!�"l]���G�>�թ�-���B&z�:��|Q.i�ےv    Ӈq�f�n��I��ux��Z C{��~��C��c���ؿ<ݝd,�fz����8[���=A��i�1T�ۦuD�&
�5Œ��R?�c!����'y�'"�MRߵ�N��!�w?�k3��ػ1�}b�F>�d4���ڇ�g���S�?��h�6�5��D઀��<���v�(�̛{zo ��W�g>Z�/w�n���b��+�p5��-�"� ��[.��+;��D��1��馡T���ba�Д���\L�{M�]��ߕy<x��(I�	��֖�3��tDV�t/NPqKF;\��[<.aΣO��<c֨,�ѽ��	��$��!"p�;T�y6�Pq0�<?D�3���)�ir��3W�A�v�VQŽ"�K�l/\h�%��݆�b�t2�?ЭyY��m?�$f>�/I��-[���7�U���L���r�~�U�S�\�b#�+u�F-�K����9v���13f1oz�a��^:�>��x���ް("���Ja���a#������N}�M�o�1(�_�v @�Ξ������(�DR���C���\d-��W;8�n�"ju�f�QG~߱@9`�{Ew�@���^�ۼ��Y��PAqV��F[�e��?)U����c�?i}Ϋ4$K�a�Yd}���q�WϘ8�NMK�)��s�կX����d{f�Aͷ���?k�g��?�C�e��zs
���)!k�|p���)p���0g��᏷������͂z�8g:�dʕ�./y��53������rN��Zy�����?��Qo�2W�S9L�?�Ǆ�l��(��l�%���l�����ީ(��:r�r要��z�\�(�W3�a�1:_�ڕ�4 �64b�v-X����>?vpD�r禮����i�n�ڤ��sz������9�ui��%Đ쒘��`�����J�qG���7�q�rS��į�(���P�p���%��v� m�2�K^-Q0��q�D>l��m7�!6�����U/�G�yP��L���o]�s��- Y�F���7"��X��8D�)�7??M���`׺s2��^��x�l�:τ��LrQ��;jzU:C�r��*�U�*M$�'ʈ�dI
m��Ƃ�I�7���8xd��{�E�΄��uyP��6�3�u�Y��-�t_&4�4;�Ty�˭�y-�ϙ�Iy�w�8�"��������_w|�ig��@ho&U�@�{[hǽ�y�Ą�d�'��^���ݲ�c��t��jḆ��k0FV<���5Zz�����ks�Fy̧|ͻ��u5|�I�`_��-�^P���^y�I���?��sT9f���ke.ؖ�I׽nl� ��>ݎ*)Sq8�M�4�O�`�D�m2^��x�(����/EL��}���`)�m�=��:?�u�ҽ��;H1�Ώ*�K�)�^�%4ɑ�RL�tM�q\)�IZJ�6x�;r�kDF�f��V@!��+�B�˄M��DA��]�,<���+�8�������t4�]��R\$ox�����9��r��^h!��㺣j�_�y��Q�*'~��%[����C�U�^�˼^�aR�:{�C���z_��l/�jZk���{�S�m��Y��^�i!�6G��z��p���H��0��;� �K�;ʢj��=�Dҝ_��649�[�֞{%W����Я�+�����捡p.�u8��Q���8�9�ip�[�
gE,���6,�6�;���`ƽ���w�=ύr��� �9�'�!nk�]��糎H��9T�yX��&�
� �z0�h��JM���c@	B���'��k1� IZ/��^:�]hGs�(/�Ù�S����U��⍗6��2�d�.4K!���k�5�e��v�ޑ�"<�,�ٸ0';Z`ooק�r :�D��8lԒz>��^[����F?Vf`���ˠ����.��7c�B�k��s��YA�vUv�gذ:0�ʂ��;c(��� n���b�H�y=4+:7j��z�7��nbԬ$u���t^�W 3b&/��� �~���9��a@����{k���e�~��#����z����>�b�ol�7���pb��[k��|��O���3�t��_ف<���,�t.,�AJkVh;��ӽ��[bm���q�ϼq��7%;�Eb`�X��8<��U>��zq���љ߭�-�=Tq�����e��L��yV�	ʜ��Qj߲�� ؜��K�8�� }�,^�j \����p��I$���%7݉�^���fX�� d�h>��'ڧf��ƽ�`6٦R�P���u%��~�訫�B8h[�n��� ���'�B擛���c�wk��e:٪�u�9_�-6����@�[Ɏ�\wz��v�X�M�*;L�����_:�7�i������C+ni�a�f�/�aI��4�z&�5��N��lG_5����񶅘��3��*@��V`�:N/Z;�	p�8��sD�j�E�Z�yy��-/��tD���4,������6oa�����W����:yN2hS��bԆ76
�7ǁN���X ��͇^���V�� �V�cP{�R~�����SNc@�K�� 6������;J���*[��F�{G+$�F8z���0{�7�����q.�Y�ϖ;�����+6�}��-ݢ˂:u�9�G��{K��7rVQ��V����<�Bg�y�0ZM�7�:�GiDJs�-�F��o��l|Qyބd�ޱV�U���B?V#�'�����+R��X㇫}b�-�����f}�f�ޤ��Q.Bj4k���Ƴ,�	~�E��k�Xc읧���'�rɔu8���P������*==������r&��;�yYWm���N�Y�_M���͜�w'i���^��F��T�ʁ'�*~@H�ݼ�q|˰Ip9���^oS!��Qm���ײ��n?�Ph�LD�1���#�w}��|�Qo@d�!Y"�6�
��l�ba?eN	6�f�}���u����O���N,G*���S���G�3CF�y{��m?1�	��� �ql��JB�U�,݄�{�-����N�yG�x6ޱ��:v����é�m@�AW�Y7���[�0���G�R#��o��ͻ}=�Ѷ�dS/�=�xa�����H�ƅ�������Yj
){��-�Q�T�;���S[NE�1���X���<�ayv׈�c�[�X������Y��7��al�/.ĉ`��^�A�b�{���9������N:~�;^��u��#R�$<��e.����ـ��h�. ��V�q�Zb����X�m�~��z�xyڕ�1�����8?�m'J&�O�m����uRm��
�
����{n�d�my������a�����-[�a�p;ª�װ�eHŬY~�H+l�����:8K��T����g]�; �(��/n#6� g��k��]�`����r��ee�Z|^��5�q�I�w�q���.���5s��-yء���N�Z��%	o��I�q�`h���0�ه�Y7�.8��`ʽ��	�r�JuY���(ɹE�G����$6�d�;UʉJYfe��� �,6��R-:x;�������<��c� � �ٛn���v�ޫ�,����x�	�ˎm�joo�}��FY��"��SىK��Z���N%Wr�,����l,;���Z�{1X��_�S�� �#\7T���]��<1 �#;��WTk�6{���&	�m��A�ۨ�	��m�K�dKHp����HF��V#z"��g5)��u
���j�7�M�d��x��TČ����bX'��.Ŝ������-R�	�X*������k�۸߼^��������jZ����P�-�����MEv��C����|���g���ܺq��~�@A�AS>[i+gi䓜5�n8&�e��gN`���d٘�ϻl�4���B����i^����q��`\d�x����:�/�;��5{9��\�Y@�@&�%���#x�������jLt��o͎:��D��Ñ��+����g=�g��dמs� A��8c�K(�V.̖��w�Z��NG|�q�]_& ׽S���Þt,~����    �� yF��10\�#�5�aB��~��c���W+?���}�v��m��8�z8�$���`+��~�q���$΋lã >ж��S�w�z7Q ���n�nJjwZ'�
�H����RU�c��.,��u��@L5�δ�sg~,�-O>·��@v�}\��M��7�y�{�Q���浩kz/�ql��,��yhB��~�U��o����@i8�hKnhz����^ǭBs����W[+doGr�<O3���|+)�Qt���w�i�jN�a� ���gÍ�G?N��̱���x�<*�ھ�Yq�_���F�pl�]2�o�g!9y9��h_�H�W�tmK"�O�4��P���В�8r����t"67����,9k�ߝ6镞��շ(��6\xY������u<���Zh����z���b���Ny`�v��PR\���	T/�.�d4�����ް8��/��lj����S�'���ZXO)���΁!C?)Q�=�<��Xҍ�� $���B�s+��Wkz��q�B]y�;�|3�J&�!]��~�N�}A�"�E?e��<bp�\�ͻp�S ��i��{o_$��^�4�M�9Y(��:�n��#jG:��9m��F=nÃ��	�F���:���BCL� 6�;��W88��0�ijshPFk������s�S�03HT@��T����;h'�ʚ�ha����6����¿�ض���Ƀ�6�m�mۼm�Wn��F#���;� ���L6R�q�".����M��N���vzY���0�5�l��1@�T{�~|�cփ� 4��@k�Fr♍L9��`-W���˴�^p��j����#���Ж�*�	��|q���XY�ul1v����n�l�?a*�	���be�Vr�W��~�:��uD9|�T����i��J�/�\̶�X��?�_�8��M���6���`�e1���nS��ݺ����~b����!<���bi�5M=vT{�=���@"�! q�GАՐwF����r��Z�Mq�j9���ةT��[>�6�[pt8כu��y_ֻ#�ǡKݚ���r�Ԟ{��)������wZk���l��W��ǧ�M�J�l�jM3ܞ�n���}q(#��d9�x��[$m�ĹNѡ|&1�:7`�p��r�C���%D��d�i�.�9�`�Q�=y�Ӝ�}�e�F��������z�w�a�w,���w��g���ym����=���>�M��؞;�ef��������:W���+�X�~L����'uB���o���?	��&;'�Z|��t�M�L<�_yz���n���4� ���f��[�1�x�bS�Q��E�]Y��D��K����[>��gީ�8D�Q삇�<���[��9v��c< �^,�:���dDSo�L�we�5�#:b�1�O�Q!C�v��n_8�~���{�" �-���J.�B��<��-����p�辽�,w�H5���7�RM�E͠wnl����;{ 垱1TG�H �Jb��x����<�:�����8�湗�Xf��u��vÊ�-������m_��ay���[u��*�cU�gۗ��mZ���2�����bx�t{Zt��ԉ�q~�-���]�����4�9��7V2[�^��4P�^3Y")�,�c�30��ޗux���8�v��M�D�?3A�'9��8����qǒ,�����-�b�>��g3͆��$C�Iʘm�}��MY�b�j�|�ׇ�]�r��Xg��鸰��uޖh}wX	��u�]��®�����G���P�q,mE6��i��1aT��҄�r�l�a/{ŏ�O�B���g����T���&�����Z{׽b�C��Ķ��eb�;3����pzl��_���!���,z%���;G��
DAU���%#w
��#4<x �T���n�6��Z�\������+���&��6��V��ΤD�o��כ㦨�zƅ=�lŶ�PH��3��.�D-��^�=��p��SM�/넜����=�\Li�E�f�j�@���������(�ǋM�Utw��C�t��:����m@��?����fwb��q5�8����>��#n���ʃ;���0�4�hO�i���x#�=���,����0�ZG��5����)�o0��W��/1Z��˹%\N�E�B:&b��4�Z5���}z�`��
�i>ū�:���hh��_�/��h^�2uG�8*�)�����^P�X1�pv(4�g�l�5�ވP���w��|"���c��	'-�y����bysެ�M���8�'�%0Ż��x�R�0ߍ�p��Zb?�e�V����β(��ʺ�-@���ث�yD�bެv���-��T �;��[�>�V��a_ts�̭"�%ޞ�2��7l?i�W��X�W	}N�W�L?*����IK�N�F1�x���B�]6GOx�t���=G�P,�<��G�O�1��͟�o1H%2���%��f��-tk�/anK>\d��ӛ6��"M��-R	���.�.{��ͭZ4���6��N^2Mr.�o�kS�t��嵎��w:@�8����1\���5@к�
fQ��^]���@?ub����KP+[��nj���S����H˔���	&|-h�w���N
�9(���c[r�n6d�Ɓ`����^;֜#�U��*��>�W�gs}r4��BP/z[l4vh��n�_�h�dl���f�;)�5�qjt�.+������!��iX�d��3��8�����V��tP���������_s"��_�jW�eog�	�	�-��U��b@o�J�z.M���&��X���+�mӊ�A�C�\��)h��:0��x+;�'���	�'��i �z�/���⽜�y��r��q��o{�?0����D�i5�7�>��E^{���8M�r����+��V��Q�a���2�a�k�]�ʾ�f���x���9f�obư�wtEq�6@f�8R�mqB�[>�sM�7{ݴ:SY�c�6�1T?׋�+h��.���8�b�����I���[������'��1xGP�r\�H�`�B�i��%5]�`�Y��9��潺R�G��BX��<w�=��'�� �M���׻#"���J!/�M3�Aɸ{^ฮ>�Sw'�A��(4�PD/԰�t�jc3V�L��X��'/���t���:��;����ƍ���N��x���?�4Ỗ�V[i38;�����v'L�q/婷��[�+�
PsҾl��\S��uPd���x0S+��g�%�9l¶h��ӆw��c@���r�2��g��8xQ��[�o<}AXj,��El��1����zp��j��	Lr�m�:�a�I3�V��	�����'�	�!l��}��4���p�aG�����F��J疛a��~U��Ɔv�ę�wXH���,����d��	���\88��Y�^�w��l솬c���q9�`m���v��vn���8��L��,ɞE�,Kz
=�^�����Dte���,���w�c��Y��I�$�>�9��1h�C2��c��vՁ6���j�=-f�1�lW���|J�Z�pl �#N��*&\��R-o�/�p0����j�-DS���q����V ��
+=�T�l5@���-æ�0ڽ���:uw���T`���ۯ���6�����]$B����ai��E�3�!?e{	�m��R�|l�J�9,O��·ms1K<C�L�Z	?n
?��,���%��iv�)	�ڂ��c�E�
9��ڳ���M&7���M�,B�l&��e)�(���8=�=f\Ͻ|T��b�~�l�e��Kң��H��Ȃq��Q֣oD�����)�,��cJ9ޡe�Вo��$�fMs��R���E���LV/��" ��ɦ��4N��p�8k9��#�9��LQ�l��O��vߒmJQ����OW����㱤d�֔��֨RuL�<��fDؗG�Oη�:n�"1��<vC�(r��kOvp5Y x8��P����N�DC����4Ye=���]�ɩ+>968Cx��t5cO��<��8�aGV�L1�s�۬�VmsO��f
)Pe��z)���    ��-���`�;�&ߛ����ƶJ�`��0��s�bh阇���.�(��ʘ�mZm���3ҩy3W�,�e�u|�1Yg��oR��>:!�{3�e�����ۥ��Nמu{
���`�C!��6�
�W�,�w&� n��!��Dr�葵}gX?�6�ܬ����>A�ȱv��c�����{uA���|CS��_������f��������[?����q �����|���ϗ�`��:/ˆj@W䊯���Jٱ%x{��ӂ]��%A�&��rSb6��QVtR6���.k�u��(�T洎�d���t����9���)~;��*<�Kq��ⷳ���ɀ�eԾ};��,,�[ɗ"���m{C{�{2?��V>���}����[���~��߼�}��%��۷?p�x��RQ��W��G�x��[�E�^��C���į�h����c$�QZ�݆	)&���.n�Nt�(��o8E;)LlZ-��R�U�n�vծY��Ẉ�x����6'���&�m?���)�5}����m~&��~��}>�����_�ϔ��oߋz��}�W��:aI�5�>��Q`Y�R�y���2e/E��������t)�k�q1S��������>ú�'�_g��؀�m$7�,oR��pJC��������&�LnP�
i_�8�S�`����	B���(���Z57&���&�бۤYp��+՛�z�N0��Q�=��9遡}�9,���n>���f}����d؝1~ ��v�f�Gכԣ��P��%���И�V
əvK͗�\�$���dIM�Z����+���Apl�m�!nb�_Rx� �Q���--��^D�+ԗ�;���g�+O$�|	��Bx�x���^uC��qI�͙�<M�lQ�Q|Y���{	[ �����[l����6����,0,c���K�a���|*`>1�����4���ul�Y�r��`12&��)m�Gט�L��|�a��~��y� �GUAy�d�>3@������e�ɜ �q��a\#��0��{�F��j\鵄��@��[�4g�)G�%�st�+� ��n��(l�G|v�w�L`��Z���⊫m0�Ap7u�*�N�<#�U�H,��j��5�y�`�.e�h�`l+}�k����O�^�X��I�wm�&��'׃Z�b��$B�L���xڕ90�z��{,�f9;H�9$����xw�ɮ(��G�e6�*��؃�cDQx��w2��ڣM�R��|+��}�X��s�)�$���4=����d�Of0l��N�fky`s�m���q�OL^'��ضjS?�}�}�{�#
M�����c���e����2ZQE��N�0JtZ_���Zn�*�V~B2�q,�-ո���]Ʋ-z�ޕ�Ѭ$W���H�*�����#mj��w�%n�!�� ;/3�n�L�����Wcy����i=���Q@�w�h�,�,Q�sZ�ϷkwQWB�eA]+�{�p[ҹ{���E⻥>�n�uH�#����/�����9�n�Y�֡�/��<R1��y��Z;%-(:��a�H[˓�SL˲�����Y*��zdx"yw�"WA9�>��Q��,椔ZV{b�t�3U�9��;���3eA��k����{�8��=��0��KE��k��;hp��,�i#Ѩ�t'��§F��@}<%E2mG�[Y��-�����ڲ��,~q��9|Y�������L��� ��v^�Uc��+��{��7�^�]��Z:���5,�%ޘ����H(b��h�;�ؖ���|c�j�����f���P"!<�Jv~����=���2}�E(�|�*��+&��&^�G���.���ao�	޶�2����T���H�A����� NLD�@գ�]���>�jo�1R2L��pt�kÅs��_��B7&�	H�К O@|aS����Yq��d=ldP2�3�@����>��V��+n���c�����yaz��xՆ�nLtĺ�#d�����a��ϕ��n��do� �a�8�QN�����x,P�TN �+�i��}��Ԭ��?{� �L�p���ʤ�.V>���s����y��������D�и=SM/ٽ�=��ucl�}3�	�����8�@T�5�Y���W��{Qߕ�$#��
��n� Gɡ�=��I��+I�^WZ֝җ�#L�R^�SH�,Yh�L�]��c�u�n��K���j3,��6��\��kB�;�p��=6�z���xW�HKf��j������v1|�i�X��]���b��\K���" �q���1�c%!ݳ�9@��+�!�Ռ�,�s�$�L������&#X����l�ee��q���~ս��E�T�������;�#��q��	%ZV�!E�jX,�R�r@��`�*d?�p1bE/��w��G����[��v0�����+t���M�R;��n0���3���d;Y�1�c���H�*LH͞/'NqU7&�*C�������(I��p����E`Z/�*�-��pI�R����N�2"�	^�
���-��4a|�z��3I��5!Rܴ ����T<Ĥ��U�T>�m?��
|���2s�E�܌b�q,��������}�T�R��e�\��E�C=C�=<�fF�h�by�����?�s�z�1���ө>F9*�����1�l�t6@iD:��,m���Ŭ�چ��T��]��l�v�h�V���U�hv��g3)/��6ٺ�	�kUw�Ľ�p����|���I�@��� O�T�4H��4-BΨg�VF#��@� X������pRw.
�=�l�z9.n㳱��~���ʔ����2�`�nG����j"�Z#o�w�F��d"Kb�@�±�/$s�<��^����	6�gI�����e��݁V/D�K\���p�υ,��������ҵK�����1K\����n�[�8�	�sQL�h�=�ub�U����~��k�8��9�_}=A%p��ДL����δ{��}aά{+�>��ΓO;R�E�Q-�-��=6�2уA�9N7@�F ��f�:�g�3e�{E�b�<���κ/԰j���������f�V���|j*_�����P���UE�el��gm�paU.���9Lo�%���PC��n��R_�\{�1��K�3�g��'%���-�{u�!�s�!�YHa���s�v�J$'m�G��D<!C;>o�n����~�h�3���\����}WK\��X�38a���W�[��]?�{쾘A�a��2��%;桻��B��sj�x"�
�|��4 "�J�b������O�hM�����bP��0������~྘�L`7/:n������ZK΢▝􅣳�*�I��f멎F�0���e!�+%����Lf��k�u"7W���[���&0��Y�d��<p�� �>�<�RS������Cܻ6�|�E{�r,�xRE�7�X�j(���s���GK�S����r��6+�X����e��cM�p�2�	�K�&f �8�X����9}E�M4,��!�_ <���-���0��>�>E�N���O���U��or�q�1��+?,��]�2S΄;���,��L�i���v�-
K�Re����JX�p��?)�lQ��5�\�X4%�y�u��D��&��n76�3$ϔ��;]1�Q.It���u1c��s>(�c{��DW�̞���1�G���#�m�x�GB�;l�~��՜ex�fa�n��dH��`�`+�~6LU��b��Q���J}�n�vS�oW�ϕ�r���s���CK{���:�9�%�|�&l�U���ǭڳ��aY�A���}'u��3����vI\�o"�b>�D������h���%��/�8��&|���(ع�4`W'(�|tJz��U�Z
�JP�d�X�"��ff��7�"���v����D)���U�
٦����c����n�v��c�FV%���ɤw��0oZ0)'s�kRS����-7���=����"�nm��O�`n�$�rGSN��Ij� �3�\P�    �^S5�����m��qZ@i2>��0����3t-M�KjkYnQ�,��q(�g��7fA�	�-R&��b��Z�
�.9���d�˭��P��Ѣ?�!,�B	ط�.�v�����b�Ƕ����a��{*�a?�f7�$Xc���{��=�LK1B�Y���VS��M���Ě%{rxV*�\�Nc0�i�(@\�u�3��.�lŇ����W��ma�Y�C c�k�C׬���%�ay�d��]���(؃�u�C�u���fV'!|����M8�܊"� T��#��
�X7�ţ���@`Gj�Ow�87/�s�y�M�3�M^↑L��rZ̈b����k��O9:�:�w���7.e0
,�f�wL��a}��Y���P��'�N��?l3*M�$�ϖ��tS
�r[˸)�����1aK5�`���1�%ɲ<�n���E�#`݃Cr��h~!
��rQ`Q���z�9a=n�(��#y�B*Y���J�=�ƙ�A�uV���
U�b�y>����[��1G,���f�P	I�����ݦ
��F,�R@�2�ȝ̽wt�'�� I5�{����k>��lUYWݎSWa�!�:�Yyߒ��a�_���n�R ,~e
499�a}���q�ֽcNE>F�{��&����
�����Q�s�G�v�²%Zj;c�U%R�&i�j\ߩ�=F��An�(�&"� '[�OsR&�q5���7�SO�5g��E�˝�����f0�e?Y ٬�k8^`c���v�y�U"3�G,Ҵ���>�x�sn֎?6�����g��+Ƌ��(ɸ+��m�[��M�ii�⃋�!Ӗ�j�p�=LC�/��V�L�������� �j �/ܓ��q����IG��ia��5(;�'��O������'-���]�pl,U���*��ݜ���I1����d������ø����%� ���&��v��n�Z�`���  %T�R_^�j_��3��8m���q����gG?���|�Drh$�KvT��x\̂j�
���������;�?/���#�RWcN�kiV��JNo7o��b���bJ/r��i�QY�#��S>�b�%���1I��¦�t�}��s3C��mQ�`�6�K?�G�$�*s��~����GR�P8��^ف����dS-�_6�a[�K�6���Ŀ�˒��B�jA�.�K��e�ȅs|�6I���U���ى|�ܶh��;T��*�ĸ�{V��Zxa�8��r�]��!������C�b6�j��_1M/O��zJ�Rk�������j6���;-�W��d�7ʬ��f�ENA+���S�	�U��.�����oM�~�/�����Ef���e�2�Ht��i��=�����㬒����2r2:�n	�V�}4"V��\��z?�[tǂ<Xć�ykc�q�ﺲ=����-1��k�����6�m�q~�
{��S^�	}�̵rq�b5�}�{`ϫ��Θ�*�}��d��$9�q�qP�l����̄[q+2�0�<]�a�w)�gBH�e�L�Dt��s����z��]>b�K�j$���%_�|n����,{�a�\�ӎOc�];f�Tv-�D�e�[~�ܞ͵k+�2��Y���%6@)*����.���=IN%s�%�5���RM��U��뽗y��WF�	/����|y���-f��ٛ�`y2����0�3r�D��H�<��'�>6���������N�dO�*�6�S��\Z/��o�z��V7�VM%���9le�kWQԎ�x�nQM�9���
���RS#}��0�3)�r�Wڵ�`��u7�m��_Q��wmaW%�	��U�����qM��%�=��|L{�Eރ杖&��;�zk�l C�Kj/�3����zm5�'����.�`�)͠@��ߚZq�pZ���79�7�Tbv�7��}x7ҿ0
ہ��, DP,c�6a��Kq\8�4�j	r�Y��wc����ܷ��,������9���p��R?���ƥʧx��pȪА� i/O��*\m'<��{��B�ж>�`�fm�;����ɨ)��8Z�o�w��u�,cOL�����n�Km�*S���c�G�e��PQ��^����ʎoA��}�w*��39O{��7i��I����1�����D�^vS𣾤P��#�M�#1�'�-=��~7�T�G�^;`���i�������m��3j�,��n�2%�A�H���5��C��gI���@~�~�&290�Y�IN}Z�wf����,�3/�"z4~�#j�|����`�vJg����Kt�a��՜VD�S��ڤ���۾e�Mt<�����n�Կ=P�nMK���Xߢ��!Jb*�4n<#FH�/��� 0Z�p[tft�����z4�I�������Jvk�/��0v�f�j���)��5}X�R�a��ġxÑ%��6��j^�`��tc���R^�R����Ӌ(��D>�E8��嗢����a��!mg�α9'����vm`@r����8��G��\���e)���׋�n�ҥM�}J)��1�\cL�F����TDg
7��k>�/C�K��-d-��?����'�00mi���Oc��`���d�s.5g:��T�%
r�6y�gdw��~̡��X,�~�$��R[qMP���g�޷��-��՗wR49U"`����b�eɉs���Yx� ��E���.[#T��v]�n[��,IRa�00�b����B.r���H���Rt<]�#Lݙ��s��]vkeB�=�XH9�lb�չ%�S�K���:����Ak�fð���J~T��Ң�A� u ��F�i�D��O�k��_�l��}��[9�+��Nmr���|��TA�_r�*<7c���qh)�T�.�ϵ�Ƿ�{�$O&p׌�~n�vp����&wE���#2)�@sO���& ��;./�-|\�2$���v�~�e��S@��g�%�T2!�{$��8����u2�y3�Q�ZK�)b3\fc;�3)b�����$��X��j^��鞔����p��wXF��cH:�ū_!W���!Ne,�ƐT�Df�ʧz��?�.xM@P���< ��o7d+����s�?��D�9�I �P�zxw	n]�B;���K!*d�4��N#+I+���� �[\���4��un��8����-�x�;������{Ϋa���;���-�d���4K�&k-�o�<![��h�� y-���Kn�'w9X{�r������$~�ݕ�<]�*�7�"u8�<���'��x�ˉ�v��(�L��nV���	��L�n��&:LP
�.�*��1i��Ӿ�ʸ+I$�1�	���f_�"�D�R�Ky�(N� �f8~4�cf�6�s��(�$G�em�zܧ8��|�O*g�Q�Y"t�m����_��-����@,2d��l�魘�����I����s�"sJc����-���7 �H�A/S��f*���4]
���������)�� %����ʼX���(�Xj�m�B�X����A8�q]��^R�L�KB�JuK�+ݾ	ڒn["�i�����dj�V7��Q���]Dw��X��Vq��=ZQ�^l���5���-���F�u�½��@d�饚f�(1Dp����LD<-�� �0�Ɓ[���
��C^�ZP�n�}��Ǡ���?�m��c�浶8� �MWO�"�|��GV�6�\u�|��*��>C����U-c��N���U�~�T	�UN@��
��Ի#�=��p5�T;?Q��e��˶�S�j|��Ѫ�Oj�8����_���k�j%Sĺ8V��>�9������Yz�-�	o+���i�n��6g� 0�Ri��i�y�ķ�·!�8%��N����c6��bi�d�vgӢH׈$����D1m�K<z~岼h&+8]5+�&N(�K�Q(g�c��՜���E�-M�ZB!��Χ��'��9ڂ�G�JV�D*U�+�l����Ҿ٘�]~�lx����>+�®oR h�s,R��o�<�4���*4���]�J��\�."E�$`~��U �  ��V��%�����0v�5��Yp,�a_v*8�p�V��
��w��zB�4�y����Wt��a�-9��̖G��u�����ATZz���B�!�8ofC_ώm?A�@RKʤ�1��l�VW�ꗷu�`?�B��ȋ�~��q�].�-��/��[�k.G}x�!+�yX�v~�4�I�ڥ_��\�����Q�0�����G�) ����ܻ�[yԻ�������X_��0�B0HY�ڙ�Yj���XqK���b�r��r�ǜ!�#���S�
����{t6���;�m��<e}������D���� <]�+�+-E۝��m3o@�׹�-�{U�u��}��y�N�¼�T�)�^4?C����4\��	pț�e�qk�چ�r�l�<7Ϝb$��C�G`ޙv��5H� �)��R�,�=1�Y�jW�E{������X>�A����V���+�'�D�\�h��z$�wӀ�#���=��f&H%�a\|�[���Y�D�2�S���p\j��g�I�U�9 �w2�;�ct2�����G�=�D��$|$��~[������"���2������全<~n�6���Ca����/�8u����v����o%5&{#�i*�/��66�{�6� ��__�*xa�T���bT5��9�yi�׮�B�첷Wn���)�щ�؃$A=�\A�|�d![+/�TD��6�j����Ң�<�/Fr'6�1_Z܄ ŋ��q
vF&�9�F2x����	ޢ���6����ʹ�~r1r��4��m��󼧴>2�YSt�cD�����!�5��R� ��q���>�#x	3����e4�풏A�'��>M̂�p*W[pv�x8�Ѓ."�c��9�����(���t��� ٚ\�=� ����S���K�X�#�,Gmn܃QdnJ8��
�nt%��m�OPg~3G��u-����nq����t�%��tg�}�|��I��V�@��O�8�UB�?����Z�b�R��v>���6��Z�)� S��G�/[������P��ܜ�Ľ�9�����6U���O�LXb��O��c5�?^��:�q׷��]¨S�I{H��O��@�c�8AUe���0�`��_����z׼s]V���Z�R��l�p"#YN��k�T��!��1��hv�|�-8�x��F�{zNI���9[�����)�IOk���$6�}����⽧qJ�R݉��>�vz�u9I�̶>֦�*����>ab���w����b9�Y8�
�M����&&�T�,�,����-���~R6��d�
`�0�^�늫�i�\I+�h��������}�O���L�.��ekW�Ɗ��J�%���K$��x\��H�I��,x)��p�V�қ��:�[oL�j>^��(�Jo���$b`�m��o��/Y��ߙO��&�dU�u��60�E���>ԓ�da��^�<�5���^�d��XRB����/$�Ҁ�\S)�^�OJG;ܭVn�?�Ki�S��\}��K�oi�T�rk߭���_݇���C(V���)�~��o�C$�.~2���u;մ�M�&�!���r�L�֘�l�t�0ܒ�W�R��Z#[z���fA���ށ���űr��We�%�S�CU���K��3��K��7����?��?�.��m%��ů������?��?�]\      ,   �   x�-�A
�0�ur��T��X�v',�B���!��HHo�s�b���:N�2Nq.S-��`p��s�w�@�i\�+�Y��X\���-/Ѫ^����YW����7Z�������V�_�(Z�-����Fa�MI)��H+�      .   #   x�3�4�400�4�30�2�4Bp�9��=... �Q7      0   $   x�3�40�4202�5��54�2B0F����� 	e	(     