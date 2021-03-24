const mySwiper = new Swiper('.swiper-container', {
	loop: true,

	// Navigation arrows
	navigation: {
		nextEl: '.slider-button-next',
		prevEl: '.slider-button-prev',
	},
});

//  cart
const buttonCart = document.querySelector('.button-cart'),
	modalCart = document.querySelector('#modal-cart');

const openModal = () => modalCart.classList.add('show');
const closeModal = () => modalCart.classList.remove('show')

buttonCart.addEventListener('click', openModal);

modalCart.addEventListener('click', event => {
	if (event.target.classList.contains('overlay') || event.target.classList.contains('modal-close')) closeModal();
});

// scroll smooth
{
	const scrollLinks = document.querySelectorAll('a.scroll-link');
	for (let scrollLink of scrollLinks) scrollLink.addEventListener('click', event => {
		event.preventDefault();
		const id = scrollLink.getAttribute('href');
		document.querySelector(id).scrollIntoView({
			behavior: "smooth",
			block: "start"
		});
	})
}

// goods

const more = document.querySelector('.more'),
	navigationItem = document.querySelectorAll('.navigation-item'),
	longGoodsList = document.querySelector('.long-goods-list');

const getGoods = () => fetch('db/db.json')
				.then(response => response.json());
	
const createCard = objCard => {
	const card = document.createElement('div');
	card.className = 'col-lg-3 col-sm-6';
	card.innerHTML = (`
		<div class="goods-card">
			<span class="label">${objCard.label}</span>
			<img src=${'db/' + objCard.img} alt="image: Hoodie" class="goods-image">
			<h3 class="goods-title">${objCard.name}</h3>
			<p class="goods-description">${objCard.description}</p>
			<button class="button goods-card-btn add-to-cart" data-id="007">
				<span class="button-price">$${objCard.price}</span>
			</button>
		</div>
	`);
	
	return card;
};

const renderCards = data => {
	longGoodsList.textContent = '';
	longGoodsList.append(...data.map(createCard));
	document.body.classList.add('show-goods');
};

getGoods().then(renderCards);
